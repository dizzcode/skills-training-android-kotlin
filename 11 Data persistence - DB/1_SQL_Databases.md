# Contents



<br>
<hr>

## 1 | Introduction

```yaml
data class Email(
    val id: Int,
    val subject: String,
    val sender: String,
    val folder: String,
    val starred: Boolean,
    val read: Boolean,
    val received: Long
)
```
In Kotlin,   
- A class like `Email` is similar to a `table` in a database. 
- The class has properties (like `id, subject, sender, folder, starred, read, and received`), which are like `columns` in the table. 
- Each object created from the class (like a `specific email`) is like a `row` in the table, with values for each property.

Just like a spreadsheet can have multiple sheets, an app can have multiple classes, and a database can have multiple tables. When a database can link or connect these tables (for example, by showing how an email can belong to different folders, like Inbox or Spam), it's called a "relational database."


<br>

## 2 | SQLite
SQLite is a lightweight relational database that uses SQL for managing data. It’s built with C and uses Structured Query Language (SQL). Sometimes pronounced as `"sequel"` for short.

In Kotlin, you're familiar with data types like Int and Boolean. Data table columns must have a specific data type. The following table maps common Kotlin data types to their SQLite equivalents.

|Kotlin data type|SQLite data type|
| --- | --- | 
| Int  | INTEGER | 
| String | VARCHAR or TEXT |
| Boolean  | BOOLEAN | 
| Float, Double  | REAL | 

<br>

## 3 | Read data with a SELECT statement

**SQL SELECT statement**  
A SQL statement—sometimes called a `query`—is used to read or manipulate a database.

A simple `SELECT` statement consists of the `SELECT` keyword, followed by the `column name`, followed by the `FROM` keyword, followed by the `table name`. Every SQL statement ends with a semicolon (`;`).  
Ex :  
SELECT `column_name(s)` FROM `table_name`; 

`Syntax :`
```sql
SELECT subject, sender FROM Email;
```
<br>

`Preview :`
| subject   | sender        |
| --------- | ------------- |
| Meeting   | a@email.com   |
| Offer     | b@email.com   |
| News      | c@email.com   |
| Reset     | d@email.com   |

<br>

If you want to select every column from the table, you use the wildcard character (`*`) in place of the column names.

`Syntax :`

```sql
SELECT * FROM Email;
```

<br>

`Preview :`

| id  | subject   | sender        | folder     | starred | read  | received    |
| --- | --------- | ------------- | ---------- | ------- | ----- | ----------- |
| 1   | Meeting   | a@email.com   | Inbox      | true    | true  | 2024-10-01  |
| 2   | Offer     | b@email.com   | Promotions | false   | false | 2024-10-02  |
| 3   | News      | c@email.com   | Inbox      | false   | true  | 2024-10-03  |
| 4   | Reset     | d@email.com   | Spam       | true    | false | 2024-10-04  |

<br>


## 4 | Reduce columns with aggregate functions

SQL offers a variety of functions that can perform an operation or calculation on a specific column, such as finding the maximum value, or counting the number of unique possible values for a particular column. 
These functions are called `aggregate functions`.

Examples of SQL aggregate functions include the following:

- `COUNT()`: Returns the total number of rows that match the query.
- `SUM()`: Returns the sum of the values for all rows in the selected column.
- `AVG()`: Returns the mean value average of all the values in the selected column.
- `MIN()`: Returns the smallest value in the selected column.
- `MAX()`: Returns the largest value in the selected column.

#

Usage :  
SELECT `aggregate function( column_name(s) )` FROM `table_name`; 

Ex : COUNT( )

`Syntax :`
```sql
SELECT COUNT(*) FROM email;
```
<br>

`Preview :`
| COUNT(*) |
| -------- |
| 4        |

<br>

#
## 5 | Filter duplicate results with DISTINCT

When you select a column, you can precede it with the DISTINCT keyword. This approach can be useful if you want to remove duplicates from the query result.

`Syntax :`
```sql
SELECT DISTINCT folder FROM email;
```
<br>

`Preview :`

| folder      |
| ----------- |
| Inbox       |
| Promotions  |
| Spam        |

<br>


Say you want to know the number of unique `folder` types in the database. You can count the number of unique `folders` with the COUNT() aggregate function and with the DISTINCT keyword on the `folder` column.

`Syntax :`
```sql
SELECT COUNT(DISTINCT folder ) FROM email;
```
<br>

`Preview :`

| COUNT(DISTINCT folder) |
| ----------------------- |
| 3                       |

<br>

#
## 6 | Filter queries with a WHERE clause

Many email apps offer the feature to filter the messages shown based on certain criteria, such as data, search term, folder, sender, etc. For these types of use cases, you can add a `WHERE` clause to your SELECT query.

> [!NOTE]
> SQL queries, it's common to put each clause on a new line for readability.


`Syntax :`
```sql
SELECT * FROM email
WHERE folder = 'inbox';
```
<br>

`Preview :`

| id | subject | sender      | folder | starred | read | received    |
|----|---------|-------------|--------|---------|------|-------------|
| 1  | Meeting | a@email.com | Inbox  | true    | true | 2024-10-01  |
| 3  | News    | c@email.com | Inbox  | false   | true | 2024-10-03  |

<br>

> [!IMPORTANT]
> Pay special attention to the SQL comparison operators!  
> Unlike in Kotlin, the comparison operator in SQL is a single equal sign (=), rather than a double equal sign (==).  
> 
> The inequality operator (!=) is the same as in Kotlin. SQL also provides comparison operators <, <=, >, and >=


<br>

#
## 7 | Logical operators with WHERE clauses | AND | OR | NOT | LIKE 

FULL EXAMPLE TABLE  | `Preview :`

| id  | subject   | sender        | folder     | starred | read  | received    |
| --- | --------- | ------------- | ---------- | ------- | ----- | ----------- |
| 1   | Meeting   | a@email.com   | Inbox      | true    | true  | 2024-10-01  |
| 2   | Offer     | b@email.com   | Promotions | false   | false | 2024-10-02  |
| 3   | News      | c@email.com   | Inbox      | false   | true  | 2024-10-03  |
| 4   | Reset     | d@email.com   | Spam       | true    | false | 2024-10-04  |



#
### AND

You can use the `AND` keyword, equivalent to the Kotlin and operator (`&&`), to only include results that satisfy both conditions.

`Syntax :`
```sql
SELECT * FROM email
WHERE folder = 'inbox' AND read = false;
```

`Preview :`
| id | subject | sender      | folder | starred | read  | received    |
|----|---------|-------------|--------|---------|-------|-------------|
| 3  | News    | c@email.com | Inbox  | false   | false | 2024-10-03  |

<br>
<br>

#
### OR

Alternatively, you can use the `OR` keyword, equivalent to the Kotlin or operator (`||`), to include rows in the results that satisfy either condition.

`Syntax :`
```sql
SELECT * FROM email
WHERE folder = 'important' OR starred = true;
```

`Preview :`
| id | subject         | sender      | folder     | starred | read  | received    |
|-|-|-|-|-|-|-|
| 1  | Meeting         | a@email.com | Inbox      | true    | true  | 2024-10-01  |
| 4  | Reset   | d@email.com | Spam       | true    | false | 2024-10-04  |


<br>
<br>

#
### NOT

For readability, you can also negate an expression using the `NOT` keyword.

**WHERE NOT `Conditon`**


> [!NOTE]
> You can also write the SQL condition `NOT folder = 'spam'` as `folder != 'spam'`

<br>
<br>

#
### LIKE

One super useful thing you can do with a WHERE clause is to search for text in a specific column. You achieve this result when you specify a column name, followed by the LIKE keyword, followed by a search string.

**WHERE column_name `Like` search_string**

The search string starts with the percent symbol (`%`), followed by the text to search for (`Search term`), followed by the percent symbol (`%`) again.

`Syntax :`
```sql
LIKE '% Search term %'
```
<br>

If you're searching for a prefix—results that begin with the specified text—omit the first percent symbol (%).

`Syntax :`
```sql
LIKE ' Search term %'
```
<br>

Alternatively, if you're searching for a suffix, omit the last percent symbol (%).

`Syntax :`
```sql
LIKE '% Search term '
```
<br>

### Example 1 |  LIKE ' Search term %'

<br>

`Syntax :`
```sql
SELECT DISTINCT * FROM email 
WHERE folder LIKE 'In%';
```


`Preview :`
| id | subject | sender      | folder | starred | read  | received    |
|----|---------|-------------|--------|---------|-------|-------------|
| 1  | Meeting | a@email.com | `In`box  | true    | true  | 2024-10-01  |
| 3  | News    | c@email.com | `In`box  | false   | true  | 2024-10-03  |

<br>


### Example 2

<br>

`Syntax :`
```sql
SELECT COUNT(*) FROM email
WHERE sender LIKE '%.com%';
```


`Preview :`
| COUNT(*) |
| -------- |
| 4        |

<br>


#
## 8 | Group, order, and limit results  

### Group results with `GROUP BY`

You can use a GROUP BY clause to group results so that all rows that have the same value for a given column are grouped next to each other in the results. This clause doesn't change the results, but only the order in which they're returned.

To add a GROUP BY clause to a SELECT statement, add the GROUP BY keyword followed by the column name you want to group results by.

<br>

`Syntax :`
```sql
SELECT folder, COUNT(*) FROM email
GROUP BY folder;
```


`Preview :`
| folder      | COUNT(*) |
|-------------|----------|
| Inbox       | 2        |
| Promotions  | 1        |
| Spam        | 1        |


<br>

> [!NOTE]
> You can specify multiple columns, separated by a comma in the `GROUP BY` clause, if you want to further separate each group into additional subgroups based on a different column.



#
### Group results with `ORDER BY`

You can also change the order of query results when you sort them with the ORDER BY clause. Add the ORDER BY keyword, followed by a column name, followed by the sort direction.

By default, the sort direction is `ascending order` (`ASC`), which you can omit from the ORDER BY clause. If you want the results sorted in `descending order`, add `DESC` after the column name.


> [!NOTE]
> Using the `ASC` keyword with the ORDER BY clause is optional.  
>SELECT * FROM email  
>ORDER BY received;

<br>

`Syntax :`
```sql
SELECT * FROM email
ORDER BY received DESC;
```


`Preview :`
| id | subject         | sender      | folder     | starred | read  | received    |
|----|-----------------|-------------|------------|---------|-------|-------------|
| 4  |  Reset   | d@email.com | Spam       | true    | false | 2024-10-04  |
| 2  |  Offer    | b@email.com | Promotions | false   | false | 2024-10-02  |
| 3  | News     | c@email.com | Inbox      | false   | true  | 2024-10-03  |
| 1  | Meeting          | a@email.com | Inbox      | true    | true  | 2024-10-01  |



<br>

#
### Restrict the number of results with `LIMIT`

 You can add a `LIMIT` clause to your query to only return a specific number of results. Add the LIMIT keyword followed by the maximum number of rows you want to return. If applicable, the LIMIT clause comes after the ORDER BY clause.

 Optionally, you can include the `OFFSET` keyword followed by another number for the number of rows to "skip".  
 For example, if you want the next ten results, after the first ten, but don't want to return all twenty results, you can use  

 ```sql
SELECT * FROM email
WHERE folder = 'inbox'
ORDER BY received DESC
LIMIT 10 OFFSET 10;
```
#

 <br>

`Syntax :`
```sql
SELECT * FROM email
WHERE folder = 'inbox'
ORDER BY received DESC
LIMIT 1;
```


`Preview :`
| id | subject | sender      | folder | starred | read  | received    |
|----|---------|-------------|--------|---------|-------|-------------|
| 3  | News    | c@email.com | Inbox  | false   | true  | 2024-10-03  |


<br>

<br>

<br>

#
## 9 | Insert, update, and delete data in a database

### `Insert` data into a database

- You can add a new row to a database with an INSERT statement.  
- An INSERT statement starts with INSERT INTO followed by the table name in which you want to insert a new row.  
- The VALUES keyword appears on a new line followed by a set of parentheses that contain a comma separated list of values.  
- You need to list the values in the same order of the database columns.

<br>

FORMAT
```sql
INSERT INTO table_name
VALUES ( value_column(s) );
```

 <br>

`Syntax :`
```sql
INSERT INTO email
VALUES (
    NULL, 'Test', 't@example.com', 'Inbox', false, false, '2024-10-04'
);
```


`Preview :`
| id | subject | sender        | folder | starred | read  | received    |
|----|---------|---------------|--------|---------|-------|-------------|
| 1  | Meeting | a@email.com   | Inbox  | true    | true  | 2024-10-01  |
| 2  | Offer | b@email.com | Promotions | false | false | 2024-10-02  |
| 3  | News | c@email.com | Inbox  | false   | true  | 2024-10-03  |
| 4  | Reset | d@email.com | Spam | true    | false | 2024-10-04  |
| `5`  | `Test`    | `t@example.com` | `Inbox`  | `false`   | `false` | `2024-10-04`  |


<br>

<br>

#
### `Update` existing data in a database

- You can update the value of one or more columns using an UPDATE statement.
- An UPDATE statement starts with the UPDATE keyword, followed by the table name, followed by a SET clause.
- A SET clause consists of the SET keyword, followed by the name of the column you want to update.
- An UPDATE statement often includes a WHERE clause to specify the single row or multiple rows that you want to update with the specified column-value pair.

<br>

FORMAT
```sql
UPDATE table_name
SET  ( sets_of_column(s)_and_value(s) )
WHERE condition(s);
```

 <br>

`Syntax :`
```sql
UPDATE email
SET read = true
WHERE id = 5;
```


`Preview :`
| id | subject | sender        | folder | starred | read  | received    |
|----|---------|---------------|--------|---------|-------|-------------|
| 1  | Meeting | a@email.com   | Inbox  | true    | true  | 2024-10-01  |
| 2  | Offer | b@email.com | Promotions | false | false | 2024-10-02  |
| 3  | News | c@email.com | Inbox  | false   | true  | 2024-10-03  |
| 4  | Reset | d@email.com | Spam | true    | false | 2024-10-04  |
| `5`  | Test    | t@example.com | Inbox  | false  | `true` | 2024-10-04  |


<br>

<br>

#
### `Delete` a row from a database

- You can use a SQL DELETE statement to delete one or more rows from a table. 
- A DELETE statement starts with the DELETE keyword, 
- followed by the FROM keyword, 
- followed by the table name, 
- followed by a WHERE clause to specify which row or rows you want to delete.



<br>

FORMAT
```sql
DELETE FROM table_name
WHERE condition(s);
```

 <br>

`Syntax :`
```sql
DELETE FROM email
WHERE id = 4;
```


`Preview :`
| id | subject | sender        | folder | starred | read  | received    |
|----|---------|---------------|--------|---------|-------|-------------|
| 1  | Meeting | a@email.com   | Inbox  | true    | true  | 2024-10-01  |
| 2  | Offer | b@email.com | Promotions | false | false | 2024-10-02  |
| 3  | News | c@email.com | Inbox  | false   | true  | 2024-10-03  |
| 5  | Test    | t@example.com | Inbox  | false  | true | 2024-10-04  |


<br>

<br>

#
## 10 | Summary

- You can now read from a database using SELECT statements, including WHERE, GROUP BY, ORDER BY, and LIMIT clauses to filter results. 
- You also learned about frequently used aggregate functions, the DISTINCT keyword to specify unique results, and the LIKE keyword to perform a text search on the values in a column. 
- Finally, you learned how to INSERT, UPDATE, and DELETE rows in a data table.