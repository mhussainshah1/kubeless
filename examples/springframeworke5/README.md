## <u>Component</u>

### @Repository

### @Services
Define Use cases

### @Transactional
method annotated with transaction intercepted by aspect

## <U>Configuration</U>
### @EnableTransactionManagement
Transaction management ability = enabled

### 1- Atomicity
Perform all operations or none of operation
If exception happen then transaction will roll back

### 2- Consistency

### 3 - Integrity

### 4 - D

### PlatformTransactionManager
There are three methods in the interface 

#### 1 - TransactionStatus getTransaction()
TransactionStatus - representation of transaction in database

#### 2 - commit()


#### 3 - rollback()
by default transaction manager rollback unchecked exception eg:-RuntimeException
not checked exception eg:- Exception


@Transaction(noRollbackFor = RuntimeException.class)
