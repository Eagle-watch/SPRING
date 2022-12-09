INSERT INTO pays (id, nom) VALUES
(1, 'France'),
(2, 'Allemagne'),
(3, 'Perou'),
(4, 'Belgique');

INSERT INTO `utilisateur`
(`id`, `nom`, `prenom`,pays_id)
VALUES (NULL, 'SMITH', 'Steeve',1), (NULL, 'SNOW', 'Jon',2), (NULL, 'DOE', 'John',3);

INSERT INTO `competence` (`id`, `nom`) VALUES
(1, 'Développeur'),
(2, 'Comptable'),
(3, 'JAVA'),
(4, 'PHP');


INSERT INTO `competence_utilisateur` (`utilisateur_id`, `competence_id`) VALUES
(1, 1),
(1, 3),
(2, 1),
(2, 4),
(3, 2);
