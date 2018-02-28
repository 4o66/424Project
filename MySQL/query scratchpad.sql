#List of courses WITH professors
select c.id
from course c
left join personcourse pc on c.id = pc.courseid
join person p on pc.personid = p.id and p.role like 'P';

#List of courses a professor may choose
select c.id, c.name, c.description, c.hours
from course c
where c.id not in (
	select c.id
	from course c
	left join personcourse pc on c.id = pc.courseid
	join person p on pc.personid = p.id and p.role like 'P'
);

#List of course a student may choose
select c.id, c.name, c.description, c.hours, concat(p.lastname, ', ', p.firstname) as 'professor'
from course c
join personcourse pc on c.id = pc.courseid
join person p on pc.personid = p.id and p.role like 'P';
