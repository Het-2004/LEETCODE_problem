# Write your MySQL query statement below
select FirstName, lastname, City, State
from Person as p left join Address as a on p.PersonId = a.PersonId;