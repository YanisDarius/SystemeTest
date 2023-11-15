-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : mer. 15 nov. 2023 à 15:54
-- Version du serveur : 10.8.3-MariaDB
-- Version de PHP : 8.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `sayebabu`
--

-- --------------------------------------------------------

--
-- Structure de la table `protocole`
--

CREATE TABLE `protocole` (
  `ref` int(11) NOT NULL,
  `idmenu` int(11) NOT NULL,
  `titre` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `idaction` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `protocole`
--

INSERT INTO `protocole` (`ref`, `idmenu`, `titre`, `description`, `idaction`) VALUES
(1, 1, 'Cut', 'Dans ce test, je souhaite trouver Cut.', 51),
(2, 1, 'Right', 'Dans ce test, je souhaite trouver Right.', 98),
(3, 1, 'Function Breakpoint...', 'Dans ce test, je souhaite trouver Function Breakpoint....', 196),
(4, 1, 'Next Problem', 'Dans ce test, je souhaite trouver Next Problem.', 176),
(8, 2, 'More...', 'Dans ce test, je souhaite trouver \"More...\".', 12);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `protocole`
--
ALTER TABLE `protocole`
  ADD PRIMARY KEY (`ref`),
  ADD KEY `fk_protocole_1` (`idmenu`),
  ADD KEY `fk_protocole_2` (`idaction`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `protocole`
--
ALTER TABLE `protocole`
  MODIFY `ref` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `protocole`
--
ALTER TABLE `protocole`
  ADD CONSTRAINT `fk_protocole_1` FOREIGN KEY (`idmenu`) REFERENCES `menu` (`idmenu`),
  ADD CONSTRAINT `fk_protocole_2` FOREIGN KEY (`idaction`) REFERENCES `menu` (`idmenu`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
