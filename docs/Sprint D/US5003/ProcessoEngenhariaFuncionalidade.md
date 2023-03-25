# US5003
=======================================

# 1. Requirements

**Title -** As Project Manager, I want the input communications (of the AGV Digital Twin) made through the SPOMSP 2022 protocol to be secured/protected.

**Acceptance criteria:**
* It should be adopted SSL/TLS with mutual authentication based on public key certificates. It complements the US5001.

# 2. Analysis

### Functional Requirements
- The AGV must be connected to the AGV Manager through an SSL Socket using public key certificates.
- The AGV must be able to communicate through packets over the internet with the AGV Manager.
- The AGV must be able to determine the purpose of a packet using the Protocol Code inside the packet.
- The AGV must be able to convert the array of bytes inside the packet to the actual data.
- The AGV must be able to calculate the best possible path to reach the product on the shelves.

### Business Rules
- In order to accept the next task, the AGV must be in the "free" state.
- In order to accept the next task, the AGV must have more than 20% battery remaining.
- After accepting a task, the AGV acquires the "busy" state.

# 3. Design

## 3.1. Functionalities

### SD - Client
![SDClient](Client-SD.png)

## 3.3. Applied patterns

* The SPOMSP 2022 (Smart Products Order Management System Protocol) Protocol was utilized to design the communications module

## 3.4. Testes 
*Nesta secção deve sistematizar como os testes foram concebidos para permitir uma correta aferição da satisfação dos requisitos.*

**Teste 1:** Verificar que não é possível criar uma instância da classe Exemplo com valores nulos.

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

    @Test
    public void dbConnectionTest() {
        Connection connection = DBUtils.createConnection();
    }

	@Test
    public void coordinatesTest(){
        int xPos = 88;
        int yPos = 33;

        Coordinates coordinates = new Coordinates(xPos, yPos);

        assertEquals(xPos, coordinates.getxPos());
        assertEquals(yPos, coordinates.getyPos());

        coordinates = new CoordinatesController().createCoordinates(xPos, yPos);

        assertEquals(xPos, coordinates.getxPos());
        assertEquals(yPos, coordinates.getyPos());
    }

    @Test
    public void byteAble(){
        int xPos = 88;
        int yPos = 33;

        Coordinates coordinates = new Coordinates(xPos, yPos);

        byte[] bytes = coordinates.getBytes(coordinates);
        Coordinates object = new Coordinates().getObject(bytes);

        assertEquals(coordinates.getxPos(), object.getxPos());
        assertEquals(coordinates.getyPos(), object.getyPos());
    }

	@Test
    public void packetTest(){
        byte version = 0;
        byte code = ProtocolCodes.SETUP.getCodeKey();
        byte[] data = "Hello World".getBytes();

        Packet packet = new Packet(version, code, data);

        assertEquals(packet.getVersion(), version);
        assertEquals(packet.getCode(), code);
        assertEquals(packet.getData(), data);

        packet = new PacketController().createPacket(version, code, data);

        assertEquals(packet.getVersion(), version);
        assertEquals(packet.getCode(), code);
        assertEquals(packet.getData(), data);
    }

	@Test
    public void pathfindingTest(){
        Pathfinding pathfinding = new Pathfinding();
        List<Coordinates> path;

        int[][] matrix1 = {
                {0, 0},
                {0, 0}
        };

        int[][] matrix2 = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        int[][] matrix3 = {
                {0, 1, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        int[][] matrix4 = {
                {0, 1, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        int[][] matrix5 = {
                {0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0}
        };

        path = pathfinding.breadthFirstSearch(matrix1, 0, 0, 1, 1);
        assertEquals(3, path.size());

        path = pathfinding.breadthFirstSearch(matrix2, 0, 0, 2, 2);
        assertEquals(5, path.size());

        path = pathfinding.breadthFirstSearch(matrix3, 0, 0, 0, 2);
        assertEquals(7, path.size());

        path = pathfinding.breadthFirstSearch(matrix4, 0, 0, 0, 2);
        assertEquals(5, path.size());

        path = pathfinding.breadthFirstSearch(matrix5, 0, 0, 2, 2);
        assertEquals(17, path.size());
    }

# 4. Implementation

*Nesta secção a equipa deve providenciar, se necessário, algumas evidências de que a implementação está em conformidade com o design efetuado. Para além disso, deve mencionar/descrever a existência de outros ficheiros (e.g. de configuração) relevantes e destacar commits relevantes;*

*Recomenda-se que organize este conteúdo por subsecções.*

# 5. Integration/Demonstration

*Nesta secção a equipa deve descrever os esforços realizados no sentido de integrar a funcionalidade desenvolvida com as restantes funcionalidades do sistema.*

# 6. Observations

*Nesta secção sugere-se que a equipa apresente uma perspetiva critica sobre o trabalho desenvolvido apontando, por exemplo, outras alternativas e ou trabalhos futuros relacionados.*