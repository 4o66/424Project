use classregistration;

INSERT INTO `classregistration`.`person` (`id`, `firstname`, `lastname`, `digest`, `role`) VALUES ('11', 'Russell', 'Payne', 'password', 'S');
INSERT INTO `classregistration`.`person` (`id`, `firstname`, `lastname`, `digest`, `role`) VALUES ('4066', 'Sean', 'Cox', 'password', 'S');
INSERT INTO `classregistration`.`person` (`id`, `firstname`, `lastname`, `digest`, `role`) VALUES ('655321', 'Alex', 'DeLarge', 'password', 'P');
INSERT INTO `classregistration`.`person` (`id`, `firstname`, `lastname`, `digest`, `role`) VALUES ('26', 'Jane', 'Smith', 'password', 'A');

INSERT INTO `classregistration`.`course` (`id`, `name`, `description`, `hours`) VALUES ('CIS-424', 'Advanced Java Programing', 'Make all the code run', '4');
INSERT INTO `classregistration`.`course` (`id`, `name`, `description`, `hours`) VALUES ('CIS-466', 'CIS Project', 'Do all the computer work for FREE', '4');

INSERT INTO `classregistration`.`personcourse` (`personid`, `courseid`) VALUES ('11', 'CIS-424');
INSERT INTO `classregistration`.`personcourse` (`personid`, `courseid`) VALUES ('655321', 'CIS-424');
INSERT INTO `classregistration`.`personcourse` (`personid`, `courseid`) VALUES ('4066', 'CIS-466');
