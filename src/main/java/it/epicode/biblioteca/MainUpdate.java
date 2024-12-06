package it.epicode.biblioteca;




import it.epicode.dao.ElementoCatalogoDAO;
import it.epicode.dao.PrestitoDAO;
import it.epicode.entity.ElementoCatalogo;
import it.epicode.entity.Libro;
import it.epicode.entity.Prestito;
import it.epicode.entity.Rivista;

import java.util.List;

public class MainUpdate {

    public static void main(String[] args) {

        ElementoCatalogoDAO catalogoDAO = new ElementoCatalogoDAO();
        PrestitoDAO prestitoDAO = new PrestitoDAO();


        ElementoCatalogo elemento = catalogoDAO.findByIsbn("123456789");
        if (elemento != null) {
            System.out.println("Elemento trovato: " + elemento.getTitolo());
        } else {
            System.out.println("Elemento non trovato!");
        }


        List<Prestito> prestitiScaduti = prestitoDAO.findPrestitiScaduti();
        System.out.println("Prestiti scaduti trovati: " + prestitiScaduti.size());


        Rivista nuovaRivista = new Rivista();
        nuovaRivista.setIsbn("456789123");
        nuovaRivista.setTitolo("Science Weekly");
        nuovaRivista.setAnnoPubblicazione(2022);
        nuovaRivista.setNumeroPagine(50);
        nuovaRivista.setPeriodicita(Rivista.Periodicita.SETTIMANALE);
        catalogoDAO.save(nuovaRivista);
        System.out.println("Nuova rivista aggiunta: " + nuovaRivista.getTitolo());

        Libro libro = new Libro();
        libro.setIsbn("123");
        libro.setTitolo("Spring Programming");
        libro.setAnnoPubblicazione(2024);
        libro.setNumeroPagine(600);
        libro.setAutore("Kate Moss");
        libro.setGenere("Informatica");
        catalogoDAO.save(libro);

        Rivista nuovaRivista1 = new Rivista();
        nuovaRivista1.setIsbn("4567891333");
        nuovaRivista1.setTitolo("Fantasy Weekly");
        nuovaRivista1.setAnnoPubblicazione(2023);
        nuovaRivista1.setNumeroPagine(60);
        nuovaRivista1.setPeriodicita(Rivista.Periodicita.MENSILE);
        catalogoDAO.save(nuovaRivista1);
        System.out.println("Nuova rivista aggiunta: " + nuovaRivista.getTitolo());
    }
}
