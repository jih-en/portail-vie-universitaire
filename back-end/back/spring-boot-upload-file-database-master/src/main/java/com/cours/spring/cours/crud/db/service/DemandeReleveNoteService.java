package com.cours.spring.cours.crud.db.service;

import com.cours.spring.cours.crud.db.Entities.DemandeReleveNote;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cours.spring.cours.crud.db.repository.DemandeReleveNoteRepository;
import com. cours. spring. cours. crud. db. service. DemandeReleveNoteService;


@Service
@RequiredArgsConstructor
public class DemandeReleveNoteService {

    @Autowired
    private DemandeReleveNoteRepository demandeReleveNoteRepository;


    private final EmailService emailService;
    //private  final MailSender mailSender;




    public DemandeReleveNote creerDemandeReleveNote(DemandeReleveNote demandeReleveNote) {
        // Enregistrer la demande de relevé de notes dans la base de données
        DemandeReleveNote savedDemande = demandeReleveNoteRepository.save(demandeReleveNote);


        // Envoyer un mail à l'administration avec les détails de la demande
        String destinataire = "dorsaf.bouoni12@gmail.com";
        String sujet = "Nouvelle demande de relevé de notes";
        String contenu = "Une nouvelle demande de relevé de notes a été soumise avec les détails suivants : \n" +
                "Raison : " + demandeReleveNote.getRaison() + "\n" +
                "Année académique : " + demandeReleveNote.getAnneeAcademique() + "\n" +
                "Étudiant : " + demandeReleveNote.getEtudiant().getNom() + " " + demandeReleveNote.getEtudiant().getPrenom();

        //sendEmail(destinataire, sujet, contenu);
        emailService.sendEmail("dorsaf.bouoni12@gmail.com",sujet,contenu);
        return savedDemande;
    }

    /*public void sendEmail(String to,String subject,String text)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("oussama.touati.178@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }*/

    public DemandeReleveNote createDemande(DemandeReleveNote demandeReleveNote) {
        return demandeReleveNoteRepository.save(demandeReleveNote);
    }


}




