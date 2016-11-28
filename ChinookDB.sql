-- SQL: Structured Query Language.. ANSI Standard
-- Creating a new record
INSERT INTO ARTIST(ARTISTID, NAME)
VALUES(300, 'The Beatles');

-- update a record (NEED A WHERE CLAUSE)
UPDATE ARTIST
SET NAME = 'Hermeto Who?'
WHERE ARTISTID = 47; --DON'T FORGET THIS.. ALWAYS USE THE PK

-- SELECTING BY PK
SELECT ARTISTID, NAME   -- ALL COLUMNS 
FROM ARTIST
WHERE ARTISTID = 47;

-- DELETE A RECORD
DELETE 
FROM PLAYLISTTRACK
WHERE PLAYLISTID = 1 AND TRACKID = 1577;
-- CONFIRM DELETE
SELECT * FROM PLAYLISTTRACK
WHERE PLAYLISTID = 1 AND TRACKID = 1577;
-- TRACK STILL EXISTS IN TRACK TABLE THOUGH
SELECT * FROM TRACK WHERE TRACKID = 1577;

-- Select complexity
SELECT * 
FROM TRACK 
WHERE NAME LIKE '%Song%'; -- wildcard:  % (0-n chars),  _  (1 char)

SELECT NAME, COMPOSER, UNITPRICE 
FROM TRACK WHERE COMPOSER like 'M%'
ORDER BY COMPOSER;

-- JOINS: TRACKS THAT WERE NEVER ORDERED
SELECT NAME AS "Track Title"  -- column alias 
FROM TRACK T                  -- table alias
LEFT JOIN INVOICELINE L
ON T.TRACKID = L.TRACKID
WHERE L.INVOICEID IS NULL;

SELECT * 
FROM TRACK 
LEFT JOIN INVOICELINE
ON TRACK.TRACKID = INVOICELINE.TRACKID;

-- self join: unary relationships
-- Employee -> manager. Get all employees and who their managers are
SELECT  CONCAT(EMP.FIRSTNAME, CONCAT(' ', EMP.LASTNAME)) AS "Employee",
        CONCAT(MGR.FIRSTNAME, CONCAT(' ', MGR.LASTNAME)) AS "Manager"
FROM EMPLOYEE EMP
LEFT JOIN EMPLOYEE MGR
ON EMP.REPORTSTO = MGR.EMPLOYEEID;
----------------------------- 11/28-----------------------------------------
-- Composite key DDL
CREATE TABLE purchase_order_line
  (
    order_id    NUMBER,
    line_id     NUMBER,
    customer_id NUMBER,
    CONSTRAINT line_pk PRIMARY KEY(order_id, line_id)
  );
/
CREATE TABLE purchase_order
  (
    order_id NUMBER,
    CONSTRAINT order_pk PRIMARY KEY(order_id)
  );
/
ALTER TABLE purchase_order_line ADD CONSTRAINT porder_fk FOREIGN KEY(order_id) REFERENCES purchase_order(order_id);
-- test
/
INSERT INTO PURCHASE_ORDER VALUES
  (1
  );
/
INSERT INTO PURCHASE_ORDER_LINE VALUES
  (1, 2, 50
  );
/
-- Indexes
-- test performance
SELECT state FROM customer WHERE state = 'SP';
/
-- create index
CREATE INDEX customer_home_state_index ON customer
  (state
  );
/
-- test before & after
DROP INDEX customer_home_state_index;
/
-- Procedures: more than 1 statement plus some logic
CREATE OR REPLACE PROCEDURE employee_fullname(
    emp_id IN NUMBER,
    emp_name OUT VARCHAR )
AS
BEGIN
  SELECT concat(firstname, concat(' ', lastname))
  INTO emp_name
  FROM employee
  WHERE EMPLOYEEID = emp_id;
END;
/
--test it
DECLARE
  full_name   VARCHAR(500); -- no assigned value
  employee_id NUMBER := 7;
BEGIN
  employee_fullname(employee_id, full_name);
  DBMS_OUTPUT.put_line('Employee name is: ' || full_name);
END;
/
-- Functions (total employees born after 1968)
-- aggregate function:  return result about an aggregation
-- sum, min, max, avg, count
-- scalar function: return result about a finite set of params
-- trim, ltrim, rtrim, length, upper, lower
-- user-defined function
CREATE OR REPLACE FUNCTION young_employees
  RETURN NUMBER 
AS emps NUMBER;
  BEGIN
    select count(employeeid)
    into emps
    from employee;
    return emps; -- HAVE TO return value
  END;
/
select YOUNG_EMPLOYEES from dual;
/
-- Sequence 
-- stores a number value you can use and increment
create sequence genre_seq 
start with 28
increment by 1;
/
-- Triggers
-- 1. change the PK to sequence value
create or replace trigger genre_trigger
  BEFORE INSERT ON Genre
  REFERENCING NEW AS N
  FOR EACH ROW 
    DECLARE
      surrogate NUMBER;
    BEGIN
      -- get next sequence value
      select genre_seq.nextval
      into surrogate
      from dual;
      -- assign the new statement's PK 
      :N.genreid := surrogate; 
      DBMS_OUTPUT.PUT_LINE('New pk is: ' || :N.genreid);
    END;
/
insert into genre values(99999, 'Chromatic Metal');
/
select * from genre;
/
create or replace trigger employee_age_trigger
before insert on EMPLOYEE
FOR EACH ROW
DECLARE 
  current_day DATE;
BEGIN
  -- get current date
  SELECT SYSDATE
  INTO current_day
  FROM DUAL;
  DBMS_OUTPUT.PUT_LINE('Today is ' || current_day);
  
  IF (:NEW.BIRTHDATE > current_day) 
    THEN
      RAISE INVALID_NUMBER; -- throw new InvalidNumberException()
  END IF;
END;
/
insert into employee(employeeid, FIRSTNAME, lastname, birthdate)
  values(102, 'Randolph', 'Scott', '11-DEC-4334');
-- Creating users
-- RMAN
/
select * from employee where employeeid = 101;
commit;
/
-- VIEW
create or replace view album_view as
  select name, title 
  from artist inner join album on artist.artistid = album.artistid;
/
select * from ALBUM_VIEW;
/
-- INSTEAD OF
CREATE OR REPLACE TRIGGER limit_void
INSTEAD OF DELETE ON INVOICE_VIEW
FOR EACH ROW
BEGIN
  IF (:OLD.TOTAL > 10) THEN
    RAISE VALUE_ERROR;
  END IF;
  
END;
/
CREATE VIEW INVOICE_VIEW AS
  select customerid, invoiceid, invoicedate, total
  from invoice;
/
select count(INVOICEID) from INVOICE;/
rollback;/
delete from INVOICE_VIEW where total < 2;
