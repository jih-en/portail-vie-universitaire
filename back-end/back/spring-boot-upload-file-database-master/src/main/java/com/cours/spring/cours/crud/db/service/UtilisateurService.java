package com.cours.spring.cours.crud.db.service;


import com.cours.spring.cours.crud.db.Entities.Etudiant;
import com.cours.spring.cours.crud.db.Entities.Validation;
import com.cours.spring.cours.crud.db.repository.EtudiantRepository;
import lombok.AllArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetailsService;
///import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.Map;
import java.util.Optional;
import com.cours.spring.cours.crud.db.service.ValidationService;
@AllArgsConstructor
@Service
public class UtilisateurService //implements UserDetailsService
{
   /* private EtudiantRepository EtudiantRepository;

    private BCryptPasswordEncoder passwordEncoder;

    private org.example.enicar2.Services.ValidationService validationService;
    public void inscription(Etudiant etudiant) {

        if(!etudiant.getEmail().contains("@")) {
            throw  new RuntimeException("Votre mail invalide");
        }
        if(!etudiant.getEmail().contains(".")) {
            throw  new RuntimeException("Votre mail invalide");
        }

        Optional<org.example.enicar2.Entities.Etudiant> utilisateurOptional = Optional.ofNullable(this.EtudiantRepository.findByEmail(etudiant.getEmail()));
        if(utilisateurOptional.isPresent()) {
            throw  new RuntimeException("Votre mail est déjà utilisé");
        }
        String mdpCrypte = this.passwordEncoder.encode(etudiant.getPassword());
        etudiant.setPassword(mdpCrypte);


        etudiant = this.EtudiantRepository.save(etudiant);
        this.validationService.enregistrer(etudiant);
    }

    public void activation(Map<String, String> activation) {
        Validation validation = this.validationService.lireEnFonctionDuCode(activation.get("code"));
        if(Instant.now().isAfter(validation.getExpiration())){
            throw  new RuntimeException("Votre code a expiré");
        }
        Etudiant etd= this.EtudiantRepository.findById((int) validation.getEtudiant().getId());
        etd.setActif(true);
            this.EtudiantRepository.save(etd);
    }

    @Override
    public Etudiant loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.EtudiantRepository
                .findByNom(username);

    }

    public Etudiant findByEmail(String username) {
        return this.EtudiantRepository
                .findByEmail(username);
    }*/
}

