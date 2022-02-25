use petstore;
CREATE TABLE `category` (
  `id` int NOT NULL,
  `category_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ;


--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `category_name`) VALUES
(1, 'dog'),
(2, 'fish'),
(3, 'parrot'),
(4, 'cat'),
(5, 'Cockatiel'),
(8, 'Small Bird'),
(9, 'long hair cat'),
(13, 'long hair dog');

-- --------------------------------------------------------

--
-- Table structure for table `pet`
--

CREATE TABLE `pet` (
  `id` int NOT NULL,
  `name` varchar(50) NOT NULL,
  `categoryid` int NOT NULL,
  `photo` varchar(50) NOT NULL,
  `tagid` int NOT NULL,
  `status` varchar(50) NOT NULL
) ;


--
-- Dumping data for table `pet`
--

INSERT INTO `pet` (`id`, `name`, `categoryid`, `photo`, `tagid`, `status`) VALUES
(1, 'german shepherd', 1, 'dog.981', 1, 'available'),
(2, 'fighter', 2, '512.png', 2, 'available'),
(3, 'pug', 1, 'pug.png', 3, 'available'),
(4, 'rose ringed parakeet', 3, 'parrot7.png', 4, 'available'),
(5, 'red parrot', 3, 'parrot17.png', 5, 'available'),
(6, 'lab', 1, '512.png', 3, 'available'),
(7, 'Mollies', 2, 'mollies.png', 7, 'available'),
(8, 'golden retriver', 1, 'retriver.png', 8, 'available'),
(9, 'Ragdoll', 4, 'c-36.png', 9, 'available'),
(10, 'weiro', 5, 'parrot7001.png', 4, 'out of stock'),
(11, 'Finches', 8, 'finch.png', 4, 'available'),
(12, 'Canaries', 8, '5188.png', 9, 'available'),
(13, 'Guppies', 2, 'Guppies.png', 4, 'available'),
(16, 'pomerian ', 1, '3.png', 1, 'available '),
(19, 'angel', 2, 'ne.png', 4, 'Avilable');

-- --------------------------------------------------------

--
-- Table structure for table `tag`
--

CREATE TABLE `tag` (
  `id` int NOT NULL,
  `tag_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ;


--
-- Dumping data for table `tag`
--

INSERT INTO `tag` (`id`, `tag_name`) VALUES
(1, 'brown'),
(2, 'blue'),
(3, 'white'),
(4, 'varity of colors'),
(5, 'green'),
(6, 'orange white'),
(7, 'golden'),
(8, 'silver'),
(9, 'yellow'),
(10, 'black'),
(11, 'ash'),
(12, 'red');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ;


--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`) VALUES
(1, 'admin', 'qburst123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pet`
--
ALTER TABLE `pet`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tagid` (`tagid`),
  ADD KEY `categoryid` (`categoryid`) USING BTREE;

--
-- Indexes for table `tag`
--
ALTER TABLE `tag`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `pet`
--
ALTER TABLE `pet`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `tag`
--
ALTER TABLE `tag`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `pet`
--
ALTER TABLE `pet`
  ADD CONSTRAINT `pet_ibfk_1` FOREIGN KEY (`categoryid`) REFERENCES `category` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `pet_ibfk_2` FOREIGN KEY (`tagid`) REFERENCES `tag` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

