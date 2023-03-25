# US1502 | 1902
=======================================

# 1. Requirements

**As a Customer, I want to view/check the status of my open orders, ie orders are not "Delivered".**
**For this we needed to build an order server and a client application. Create a connection between the two applications and send and receive packets.**

- For the customer, we wanted to verify the details of 'my orders open'. <br>
- For the customer, we wanted to access the database to get the requested data and send it via SSL Socket to the customer. <br>
- For the Project Manager, he wanted the communications to be done through the SPOMS2022 protocol to be safe/secure. <br>

**As a group, we decided that customers only need to present their credentials and we received the ID. So we created a console interface with login and options that interact between modules.**

**2) As a Project Manager, I want communications made through the SPOMS2022 protocol to be secure/secure.**

**Acceptance criteria:**
* It is mandatory using the "OrdersServer" component (cf. US1901).
* It should be adopted SSL/TLS with mutual authentication based on public key certificates. It complements the US2005.

**Requirements Clarifications:**
* Q1: In the US 1502, it is asked to "view/check the status of my open orders", can you clarify if the open orders are all the orders that have been created or if it is orders with a specific status.
    * A: It is all orders that have not been delivered to the customer yet.

# 2. Analysis

**Functional Requirements**
- Build an app to Customers that connects to OrderServer
- Ensure that packets are being sending and received

# 3. Design

## 3.1. Realização da Funcionalidade

### SD Server -> Handshake
![SD](SD_Server.png)

### SD Client -> Handshake
![SD](SD_CustomerApp.png)

## 3.3. Padrões Aplicados

* The SPOMSP 2022 (Smart Products Order Management System Protocol) Protocol was utilized to design the communications module


* The SPOMS2022P was utilized to design the communications module

## 3.4. Tests 
*Tests to Packet domain class and test connections*

	@Test
    public void packetTest(){
        byte version = 0;
        byte code = ProtocolCodes.SETUP.getCodeKey();
        byte[] data = "Packet Test".getBytes();
        byte dLength1 = 1;
        byte dLength2 = 2;


        Packet packet = new Packet(version, code, data, dLength2, dLength1);

        assertEquals(packet.getVersion(), version);
        assertEquals(packet.getCode(), code);
        assertEquals(packet.getData(), data);
        assertEquals(packet.getLength(), dLength2);
    }

    @Test
    public void socketConnectionTest() throws IOException {
        SSLSocket cs = SocketUtils.createSocketClient(InetAddress.getByName("google.com"), 443);

        InputStream in = cs.getInputStream();
        OutputStream out = cs.getOutputStream();

        out.write(1);

        while (in.available() > 0) {
            System.out.print(in.read());
        }

        System.out.println("Successfully connected.");
    }

# 4. Implementação

*Nesta secção a equipa deve providenciar, se necessário, algumas evidências de que a implementação está em conformidade com o design efetuado. Para além disso, deve mencionar/descrever a existência de outros ficheiros (e.g. de configuração) relevantes e destacar commits relevantes;*

*Recomenda-se que organize este conteúdo por subsecções.*

# 5. Integração/Demonstração

*Nesta secção a equipa deve descrever os esforços realizados no sentido de integrar a funcionalidade desenvolvida com as restantes funcionalidades do sistema.*

# 6. Observações

*Nesta secção sugere-se que a equipa apresente uma perspetiva critica sobre o trabalho desenvolvido apontando, por exemplo, outras alternativas e ou trabalhos futuros relacionados.*