-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 18-Maio-2022 às 15:26
-- Versão do servidor: 10.4.21-MariaDB
-- versão do PHP: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `itinerario`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `itinerario`
--

CREATE TABLE `itinerario` (
  `idLinha` int(11) NOT NULL,
  `id` int(10) NOT NULL,
  `lat` varchar(25) NOT NULL,
  `lng` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `itinerario`
--

INSERT INTO `itinerario` (`idLinha`, `id`, `lat`, `lng`) VALUES
(5566, 0, '-30.03091357845100000', '-51.22586811462900000'),
(5566, 1, '-30.03098657845100000', '-51.22481211462900000');

-- --------------------------------------------------------

--
-- Estrutura da tabela `linhas`
--

CREATE TABLE `linhas` (
  `id` int(10) NOT NULL,
  `codigo` varchar(10) NOT NULL,
  `nome` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `linhas`
--

INSERT INTO `linhas` (`id`, `codigo`, `nome`) VALUES
(5037, '214-1', '5\\u00aa UNIDADE\\/ESCOLAR'),
(5038, '214-2', '5\\u00aa UNIDADE\\/ESCOLAR'),
(5039, '2141-1', '5\\u00aa UNIDADE\\/ESCOLAR II'),
(5482, 'T11-1', '3ª PERIMETRAL'),
(5483, 'T11-2', '3\\u00aa PERIMETRAL'),
(5525, '250-1', '1 DE MAIO'),
(5526, '250-2', '1 DE MAIO'),
(5566, '270-2', 'GRUTINHA'),
(6032, 'T111-2', '3\\u00aa PERIMETRAL\\/ATE DR. CAMPOS VELHO'),
(6038, 'T111-1', '3\\u00aa PERIMETRAL\\/ATE DR. CAMPOS VELHO');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `itinerario`
--
ALTER TABLE `itinerario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_linhas` (`idLinha`);

--
-- Índices para tabela `linhas`
--
ALTER TABLE `linhas`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `itinerario`
--
ALTER TABLE `itinerario`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `itinerario`
--
ALTER TABLE `itinerario`
  ADD CONSTRAINT `fk_linhas` FOREIGN KEY (`idLinha`) REFERENCES `linhas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
