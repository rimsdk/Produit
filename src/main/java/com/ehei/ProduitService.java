package com.ehei;
import java.util.ArrayList;
import java.util.List;

public class ProduitService {
    private List<Produit> produits;

    public ProduitService() {
        this.produits = new ArrayList<>();
    }


    public void createProduit(Produit PROD) {
        if (!estUnique(PROD)) {
            System.out.println("produit deja existe.");
            return;
        }

        if (!sontDonneesValides(PROD)) {
            System.out.println("donnes non valides");
            return;
        }

        produits.add(PROD);
    }

    public Produit lireProduitParId(long id) {
        for (Produit produit : produits) {
            if (produit.getId() == id) {
                return produit;
            }
        }
        System.out.println("Produit inexistant.");
        return null;
    }
        public void supprimerProduit(long id) {
        Produit produitASupprimer = lireProduitParId(id);
        if (produitASupprimer != null) {
            produits.remove(produitASupprimer);
        } else {
            System.out.println("Produit inexistant.");
        }
    }

    private boolean estUnique(Produit produit) {
        return produits.stream().noneMatch(p -> p.getId() == produit.getId() || p.getNom().equals(produit.getNom()));
    }



    private boolean sontDonneesValides(Produit produit) {
        if (produit.getPrix() <= 0 || produit.getQuantite() <= 0) {
            return false;
        }
        return true;
    }

}