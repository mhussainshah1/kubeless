Transaction is ACID.

Atomicity

Consistency

Isolation 

Durability

#### Repository: 
- The classes in the repository package communicate with database

#### Service
- The classes in the services package are use cases

## @PostConstruct 
The method called during the creation of bean right after injection of bean 


## Problems With Synchronous Transaction:

### 1) Dirty Reads    
- the **value change** of uncommitted transaction (T2) of a record can be seen by other transaction (T1) and T1 read the wrong value if T2 rollbacks.
```
T1 --------$10-----------------------$20(read)-----------------> read 20
T2-----------------------$20-----------------------------------> if rollbacks then actual value is 10 not 20
```

### 2) Repeatable Read 
- the **value change** of committed transaction (T2) of a record can be seen by other transaction (T1), and if we have multiple read of T1 in a time then it would give different values.
```
T1 --------$10-----------------------$20(read)----------------> read 20
T2-----------------------$20 (commit)------------------------->
```

### 3) Phantom Reads 
- The later addition of rows in a group of record is called phantom data.
```
T1 --------100 product-------------------total 110 product-----> 10 phantom products appear at end which were not at beggining
T2-----------------------10 product (add)---------------------->
```

## Isolation Level: 
when two or more transaction run simultaneously. We can apply isolation level for consistency of data.

### 1) DEFAULT 
- not declared from @Transaction, and it is taken from under layer. It is normally read committed
### 2) READ_UNCOMMITTED 
- The one transaction can see the uncommitted change of another transaction.It gives fast performance and low consistency. This isolation level use in website having posting messages
### 3) READ_COMMITTED 
- use to avoid dirty reads
### 4) REPEATABLE_READ 
- use to avoid dirty and repeatable reads
### 5) SERIALIZABLE 
- use to avoid dirty, repeatable reads and phantom reads     

## @Transactional
by default transaction rollback at runtime exception and do not roll back at checked exception.We can change the default behaviour by following attributes

1) @Transaction uses the following attributes if we have class at compile time
#### rollbackFor 
override the rollback policy on checked exception
#### noRollbackFor 
do not override the rollback policy on unchecked exception

2) @Transaction uses the following if we have class at runtime
#### rollbackForClassName
#### noRollbackForClassName

#### readOnly 
- no changes in the database. The run tx faster
#### timeout
- specify the time to complete transaction otherwise it rollbacks
#### value
- alias of transaction Manager