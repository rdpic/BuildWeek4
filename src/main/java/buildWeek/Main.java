package buildWeek;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import buildWeek.DAO.*;
import buildWeek.Entity.*;
import buildWeek.Enum.*;

public class Main {

    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Benvenuto, quanti biglietti desideri acquistare?");
//        Integer biglietti = scanner.nextInt();
//        scanner.nextLine();
//
//        System.out.println("Da dove parti?");
//        System.out.println("-Napoli \n-Roma \n-Firenze \n-Frosinone \n-Milano");
//        String inizio = scanner.nextLine();
//        System.out.println("Hai scelto di partire da: " + inizio + ". Dove vuoi andare?");
//        System.out.println("-Venezia \n-Bologna \n-Torino \n-Palermo \n-Bari");
//        String arrivo = scanner.nextLine();
//
//        System.out.println("Stai acquistando " + biglietti + " biglietti per un viaggio da " + inizio + " fino a " + arrivo);


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("trasportopubblico");
        EntityManager em = emf.createEntityManager();

        Utente utente1 = new Utente(Tessera.ABBONATO,"Pippo","Bianchi");
        UtentiDao utentiDao = new UtentiDao(em);
        utentiDao.save(utente1);

        Mezzo mezzo1 = new Mezzo(Servizio.ATTIVO, CapienzaMezzo.DUECENTO, TipoMezzo.AUTOBUS);
        List<Mezzo> mezzi = new ArrayList<>();
        mezzi.add(mezzo1);

        MezziDao mezziDao = new MezziDao(em);
        mezziDao.save(mezzi);


        Tratta tratta1 = new Tratta("Roma","Napoli",40,mezzi);
        TrattaDao trattaDao = new TrattaDao(em);
         trattaDao.save(tratta1);

        Biglietto biglietto1 = new Biglietto(false, LocalTime.of(10,20,25),LocalTime.of(11,50,55),utente1,tratta1);
        BigliettiDao bigliettiDao = new BigliettiDao(em);
        bigliettiDao.save(biglietto1);


        Viaggio viaggio1 = new Viaggio( LocalTime.of(10,20,25), LocalTime.of(12,20,25),biglietto1,mezzo1);
        ViaggioDao viaggioDao = new ViaggioDao(em);
        viaggioDao.save(viaggio1);

        Abbonamento abbonamento1 = new Abbonamento(Stato.ATTIVO,DurataAbbonamento.ANNUALE);
        AbbonamentiDao abbonamentiDao = new AbbonamentiDao(em);
        abbonamentiDao.save(abbonamento1);


        List<BigliettoEAbbonamento> listaTotale = new ArrayList<>();
        listaTotale.add(biglietto1);
        listaTotale.add(abbonamento1);




        DistributoreAutomatico distributore1 = new DistributoreAutomatico(StatoDistributori.ATTIVO,listaTotale);
        List<DistributoreAutomatico> distributori = new ArrayList<>();
        distributori.add(distributore1);
        DistributoreAutomaticoDao distributoreAutomaticoDao = new DistributoreAutomaticoDao(em);
        distributoreAutomaticoDao.save(distributori);

        Rivenditore rivenditore1 = new Rivenditore();
        List<Rivenditore> rivenditori = new ArrayList<>();
        rivenditori.add(rivenditore1);
        RivenditoreDao rivenditoreDao = new RivenditoreDao(em);
        rivenditoreDao.save(rivenditori);

       BigliettoEAbbonamento bigliettoEAbbonamento = new BigliettoEAbbonamento(distributori,rivenditori);

       Manutenzione manutenzione1 = new Manutenzione(LocalDate.of(2024, 1,10), LocalDate.of(2024, 2,15),);
       List<Manutenzione> manutenzioni = new ArrayList<>();
       manutenzioni.add(manutenzione1);
       ManutenzioneDao manutenzioneDao = new ManutenzioneDao(em);
       manutenzioneDao.save(manutenzioni);















//        Tratta tratta2 = new Tratta("Frosinone","Messina",200);
//        TrattaDao trattaDao = new TrattaDao(em);
//         trattaDao.save(tratta1);
//          trattaDao.save(tratta2);










    }

}
