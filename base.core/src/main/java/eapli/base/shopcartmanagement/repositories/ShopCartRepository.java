package eapli.base.shopcartmanagement.repositories;

import eapli.base.productmanagement.domain.Product;
import eapli.base.shopcartmanagement.domain.ShopCart;
import eapli.base.shopcartmanagement.domain.ShopCartID;
import eapli.framework.domain.repositories.DomainRepository;

public interface ShopCartRepository extends DomainRepository<ShopCartID, ShopCart> {

}
