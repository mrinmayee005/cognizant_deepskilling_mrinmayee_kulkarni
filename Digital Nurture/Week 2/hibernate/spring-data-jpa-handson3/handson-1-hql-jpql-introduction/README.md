# Hands-on 1: Introduction to HQL and JPQL

## HQL

HQL means Hibernate Query Language.

It is an object-oriented query language provided by Hibernate. HQL queries use entity class names and Java field names, not database table names and column names.

Example:

```java
@Query("SELECT e FROM Employee e WHERE e.permanent = true")
List<Employee> getAllPermanentEmployees();
```

Here `Employee` is the Java entity class and `permanent` is the Java field.

## JPQL

JPQL means Java Persistence Query Language.

JPQL is the standard query language defined by JPA. It is also object-oriented and works with entity classes and fields.

## HQL vs JPQL

- JPQL is a standard JPA query language.
- HQL is Hibernate's query language.
- JPQL is a subset of HQL.
- All JPQL queries are valid HQL queries.
- All HQL queries may not be valid JPQL queries.
- Both support `SELECT`, `UPDATE`, and `DELETE`.
- HQL additionally supports `INSERT`.

## Important Point

SQL uses table and column names:

```sql
SELECT * FROM employee WHERE em_permanent = 1;
```

HQL/JPQL uses entity and field names:

```java
SELECT e FROM Employee e WHERE e.permanent = true
```

