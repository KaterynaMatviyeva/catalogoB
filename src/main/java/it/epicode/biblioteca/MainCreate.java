package it.epicode.biblioteca;



import it.epicode.dao.*;
import it.epicode.entity.*;

import java.time.LocalDate;

public class MainCreate {

    public static void main(String[] args) {

        ElementoCatalogoDAO catalogoDAO = new ElementoCatalogoDAO();
        UtenteDAO utenteDAO = new UtenteDAO();
        PrestitoDAO prestitoDAO = new PrestitoDAO();


        Libro libro = new Libro();
        libro.setIsbn("123456789");
        libro.setTitolo("Java Programming");
        libro.setAnnoPubblicazione(2021);
        libro.setNumeroPagine(500);
        libro.setAutore("John Doe");
        libro.setGenere("Informatica");
        catalogoDAO.save(libro);


        Rivista rivista = new Rivista();
        rivista.setIsbn("987654321");
        rivista.setTitolo("Tech Monthly");
        rivista.setAnnoPubblicazione(2023);
        rivista.setNumeroPagine(100);rivista.setPeriodicita(Rivista.Periodicita.MENSILE);
        catalogoDAO.save(rivista);


        Utente utente = new Utente();
        utente.setNome("Mario");
        utente.setCognome("Rossi");
        utente.setDataNascita(LocalDate.of(1990, 1, 1));
        utente.setNumeroTessera("U12345");
        utenteDAO.save(utente);


        Prestito prestito = new Prestito();
        prestito.setUtente(utente);
        prestito.setElementoPrestato(libro);
        prestito.setDataInizioPrestito(LocalDate.now());
        prestito.setDataRestituzionePrevista(LocalDate.now().plusDays(30));
        prestitoDAO.save(prestito);

        System.out.println("Database creato e popolato con dati iniziali!");




    }
}
