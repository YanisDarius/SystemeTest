-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : mer. 15 nov. 2023 à 15:20
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
-- Structure de la table `menu`
--

CREATE TABLE `menu` (
  `idmenu` int(11) NOT NULL,
  `nom` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `idpere` int(11) DEFAULT NULL,
  `poids` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `menu`
--

INSERT INTO `menu` (`idmenu`, `nom`, `idpere`, `poids`) VALUES
(1, 'Visual Studio Code', NULL, 0),
(2, 'File', 1, 0),
(3, 'New Text File', 2, 0),
(4, 'New File...', 2, 1),
(5, 'New Window', 2, 2),
(6, 'Open File...', 2, 3),
(7, 'Open Folder...', 2, 4),
(8, 'Open Workspace from File...', 2, 5),
(9, 'Open Recent', 2, 6),
(10, 'Reopen Closed Editor', 9, 0),
(11, 'C:\\La\\DEV\\Est\\Superieur\\A\\La\\SCR', 9, 1),
(12, 'More...', 9, 3),
(13, 'Clear Recently Opened', 9, 4),
(14, 'Add Folder to Workspace...', 2, 7),
(15, 'Save Workspace As...', 2, 8),
(16, 'Duplicate Workspace', 2, 9),
(17, 'Save', 2, 10),
(18, 'Save As...', 2, 11),
(19, 'Save All', 2, 12),
(20, 'Share', 2, 13),
(21, 'Export Profile (Default)...', 20, 0),
(22, 'Import Profile...', 20, 1),
(23, 'Auto Save', 2, 14),
(24, 'Preferences', 2, 15),
(25, 'Profiles (Default)', 24, 0),
(26, 'Default', 25, 0),
(27, 'Show Profile Contents', 25, 1),
(28, 'Create Profile...', 25, 2),
(29, 'Delete Profile...', 25, 3),
(30, 'Export Profile...', 25, 4),
(31, 'Import Profile...', 25, 5),
(32, 'Settings', 24, 1),
(33, 'Extensions', 24, 2),
(34, 'Keyboard Shortcuts', 24, 3),
(35, 'Configure User Snippets', 24, 4),
(36, 'User Tasks', 24, 5),
(37, 'Theme', 24, 6),
(38, 'Color Theme', 37, 0),
(39, 'File Icon Theme', 37, 1),
(40, 'Product Icon Theme', 37, 2),
(41, 'Online Services Settings...', 24, 7),
(42, 'Backup and Sync Settings...', 24, 8),
(43, 'Revert File', 2, 16),
(44, 'Close Editor', 2, 17),
(45, 'Close Folder', 2, 18),
(46, 'Close Window', 2, 19),
(47, 'Exit', 2, 20),
(48, 'Edit', 1, 1),
(49, 'Undo', 48, 0),
(50, 'Redo', 48, 1),
(51, 'Cut', 48, 2),
(52, 'Copy', 48, 3),
(53, 'Paste', 48, 4),
(54, 'Find', 48, 5),
(55, 'Replace', 48, 6),
(56, 'Find in Files', 48, 7),
(57, 'Replace in Files', 48, 8),
(58, 'Toggle Line Comment', 48, 9),
(59, 'Toggle BLock Comment', 48, 10),
(60, 'Emmet: Expand Abbreviation', 48, 11),
(61, 'Selection', 1, 2),
(62, 'Select All', 61, 0),
(63, 'Expand Selection', 61, 1),
(64, 'Shrink Selection', 61, 2),
(65, 'Copy Line Up', 61, 3),
(66, 'Copy Line Down', 61, 4),
(67, 'Move Line Up', 61, 5),
(68, 'Move Line Down', 61, 6),
(69, 'Duplicate Selection', 61, 7),
(70, 'Add Cursor Above', 61, 8),
(71, 'Add Cursor Below', 61, 9),
(72, 'Add Cursors to Line Ends', 61, 10),
(73, 'Add Next Occurrence', 61, 11),
(74, 'Add Previous Occurrence', 61, 12),
(75, 'Select All Occurrences', 61, 13),
(76, 'Switch to Ctrl+Click for Multi-Cursor', 61, 14),
(77, 'Column Selection Mode', 61, 15),
(78, 'View', 1, 3),
(79, 'Command Palette...', 78, 0),
(80, 'Open View...', 78, 1),
(81, 'Appearance', 78, 2),
(82, 'Full Screen', 81, 0),
(83, 'Zen Mode', 81, 1),
(84, 'Centered Layout', 81, 2),
(85, 'Menu Bar', 81, 3),
(86, 'Primary Side Bar', 81, 4),
(87, 'Secondary Side Bar', 81, 5),
(88, 'Status Bar', 81, 6),
(89, 'Panel', 81, 7),
(90, 'Activity Bar Position', 81, 8),
(91, 'Side', 90, 0),
(92, 'Top', 90, 1),
(93, 'Hidden', 90, 2),
(94, 'Move Primary Side Bar Right', 81, 9),
(95, 'Panel Position', 81, 10),
(96, 'Bottom', 95, 0),
(97, 'Left', 95, 1),
(98, 'Right', 95, 2),
(99, 'Align Panel', 81, 11),
(100, 'Center', 99, 0),
(101, 'Justify', 99, 1),
(102, 'Left', 99, 2),
(103, 'Right', 99, 3),
(104, 'Tab Bar', 81, 12),
(105, 'Multiple Tabs', 104, 0),
(106, 'Single Tab', 104, 1),
(107, 'Hide', 104, 2),
(108, 'Minimap', 81, 13),
(109, 'Breadcrumbs', 81, 14),
(110, 'Sticky Scroll', 81, 15),
(111, 'Render Whitespace', 81, 16),
(112, 'Render Control Characters', 81, 17),
(113, 'Zoom In', 81, 18),
(114, 'Zoom Out', 81, 19),
(115, 'Reset Zoom', 81, 20),
(116, 'Edit Layout', 78, 3),
(117, 'Split Up', 116, 0),
(118, 'Split Down', 116, 1),
(119, 'Split Left', 116, 2),
(120, 'Split Right', 116, 3),
(121, 'Split in Group', 116, 4),
(122, 'Single', 116, 5),
(123, 'Two Columns', 116, 6),
(124, 'Three Columns', 116, 7),
(125, 'Two Rows', 116, 8),
(126, 'Three Rows', 116, 9),
(127, 'Grid (2x2)', 116, 10),
(128, 'Two Rows Right', 116, 11),
(129, 'Two Columns Bottom', 116, 12),
(130, 'Flip Layout', 116, 13),
(131, 'Explorer', 78, 4),
(132, 'Search', 78, 5),
(133, 'Source Control', 78, 6),
(134, 'Run', 78, 7),
(135, 'Extensions', 78, 8),
(136, 'Problems', 78, 9),
(137, 'Output', 78, 10),
(138, 'Debug Console', 78, 11),
(139, 'Terminal', 78, 12),
(140, 'Word Wrap', 78, 13),
(141, 'Go', 1, 4),
(142, 'Back', 141, 0),
(143, 'Forward', 141, 1),
(144, 'Last Edit Location', 141, 2),
(145, 'Switch Editor', 141, 3),
(146, 'Next Editor', 145, 0),
(147, 'Previous Editor', 145, 1),
(148, 'Next Used Editor', 145, 2),
(149, 'Previous Used Editor', 145, 3),
(150, 'Next Editor in Group', 145, 4),
(151, 'Previous Editor in Group', 145, 5),
(152, 'Next Used Editor in Group', 145, 6),
(153, 'Previous Used Editor in Group', 145, 7),
(154, 'Switch Group', 141, 5),
(155, 'Group 1', 154, 0),
(156, 'Group 2', 154, 1),
(157, 'Group 3', 154, 2),
(158, 'Group 4', 154, 3),
(159, 'Group 5', 154, 4),
(160, 'Next Group', 154, 5),
(161, 'Previous Group', 154, 6),
(162, 'Group Left', 154, 7),
(163, 'Group Right', 154, 8),
(164, 'Group Above', 154, 9),
(165, 'Group Below', 154, 10),
(166, 'Go to File...', 141, 6),
(167, 'Go to Symbol in Workspace...', 141, 7),
(168, 'Go to Symbol in Editor...', 141, 8),
(169, 'Go to Definition', 141, 9),
(170, 'Go to Declaration', 141, 10),
(171, 'Go to Type Definition', 141, 11),
(172, 'Go to Implementations', 141, 12),
(173, 'Go to References', 141, 13),
(174, 'Go to Line/Column...', 141, 14),
(175, 'Go to Bracket', 141, 15),
(176, 'Next Problem', 141, 16),
(177, 'Previous Problem', 141, 17),
(178, 'Next Change', 141, 18),
(179, 'Previous Change', 141, 19),
(180, 'Run', 1, 5),
(181, 'Start Debugging', 180, 0),
(182, 'Run Without Debugging', 180, 1),
(183, 'Stop Debugging', 180, 2),
(184, 'Restart Debugging', 180, 3),
(185, 'Open Configurations', 180, 4),
(186, 'Add Configuration...', 180, 5),
(187, 'Step Over', 180, 6),
(188, 'Step Into', 180, 7),
(189, 'Step Out', 180, 8),
(190, 'Continue', 180, 9),
(191, 'Toggle Breakpoint', 180, 10),
(192, 'New Breakpoint', 180, 11),
(193, 'Conditional Breakpoint...', 192, 0),
(194, 'Edit Breakpoint', 192, 1),
(195, 'Inline Breakpoint', 192, 2),
(196, 'Function Breakpoint...', 192, 3),
(197, 'Logpoint...', 192, 4),
(198, 'Enable All Breakpoints', 180, 12),
(199, 'Disable All Breakpoints', 180, 13),
(200, 'Remove All Breakpoints', 180, 14),
(201, 'Install additional Debuggers...', 180, 15),
(202, 'Terminal', 1, 6),
(203, 'New Terminal', 202, 0),
(204, 'Split Terminal', 202, 1),
(205, 'Run Task...', 202, 2),
(206, 'Run Build Task...', 202, 3),
(207, 'Run Active File', 202, 4),
(208, 'Run Selected Text', 202, 5),
(209, 'Show Running Tasks...', 202, 6),
(210, 'Restart Running Task...', 202, 7),
(211, 'Terminate Task...', 202, 8),
(212, 'Configure Tasks...', 202, 9),
(213, 'Configure Default Build Task...', 202, 10),
(214, 'Help', 1, 7),
(215, 'Welcome', 214, 0),
(216, 'Show All Commands', 214, 1),
(217, 'Documentation', 214, 2),
(218, 'Editor Playground', 214, 3),
(219, 'Show Release Notes', 214, 4),
(220, 'Keyboard Shortcuts Reference', 214, 5),
(221, 'Video Tutorials', 214, 6),
(222, 'Tips and Tricks', 214, 7),
(223, 'Join Us on YouTube', 214, 8),
(224, 'Search Feature Requests', 214, 9),
(225, 'Report Issue', 214, 10),
(226, 'View License', 214, 11),
(227, 'Privacy Statement', 214, 12),
(228, 'Toggle Developer Tools', 214, 13),
(229, 'Open Process Explorer', 214, 14),
(230, 'Check for Updates...', 214, 15),
(231, 'About', 214, 16),
(232, 'C:\\On\\Veut\\Le\\Projet\\Android', 9, 2);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`idmenu`),
  ADD KEY `fk_menu_1` (`idpere`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `menu`
--
ALTER TABLE `menu`
  MODIFY `idmenu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=233;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `menu`
--
ALTER TABLE `menu`
  ADD CONSTRAINT `fk_menu_1` FOREIGN KEY (`idpere`) REFERENCES `menu` (`idmenu`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
