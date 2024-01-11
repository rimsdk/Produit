package com.ehei;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class ProduitServiceTest {
    private ProduitService produitService;

    @Before
    public void setUp() {
        produitService = new ProduitService();
    }

    @Test
    public void testCreationProduit() {
        Produit produit = new Produit(1L, "Article", 19.09, 1);

        produitService.createProduit(produit);

        assertEquals(1, produitService.getProduits().size());
        assertEquals(produit, produitService.getProduits().get(0));
    }

    @Test
    public void testCreationProduitProduitExisteDeja() {
        Produit produit1 = new Produit(1L, "Article1", 13.69, 1);
        Produit produit2 = new Produit(1L, "Article2", 207.78, 3);

        produitService.createProduit(produit1);
        produitService.createProduit(produit2);

        assertEquals(1, produitService.getProduits().size());
        assertEquals(produit1, produitService.getProduits().get(0));
    }

    @Test
    public void testCreationProduitDonneesNonValides() {
        Produit produit = new Produit(2L, "Article3", -5.0, 2);

        produitService.createProduit(produit);

        assertEquals(0, produitService.getProduits().size());
    }

    @Test
    public void testLireProduitParId() {
        Produit produit = new Produit(1L, "Article4", 18.75, 5);

        produitService.createProduit(produit);

        Produit produitLu = produitService.lireProduitParId(1L);

        assertNotNull(produitLu);
        assertEquals(produit, produitLu);
    }

    @Test
    public void testLireProduitParIdInexistant() {
        Produit produit = produitService.lireProduitParId(2L);

        assertNull(produit);
    }


}
