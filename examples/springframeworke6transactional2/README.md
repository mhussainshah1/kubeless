How to use transaction ability in spring?
1) @EnableTransactionManagement in the configuration file

2) add @Transactional on class or method level.


## @Transactional (<i><level_of_propagation></i>)
 
It is annotated on class and method level

- class level annotation - It applies to every method declare in the class. If we define method level annotation then It overrides the transaction propagation level at class level
- method level annotation - It applies to specific method

#### Exception : 
+ Unchecked Exception will roll back the transaction
+ Checked Exception will not roll back the transaction

## Level Of Propagation
  ### 1- REQUIRED - default propagation - It creates transaction if there is no transaction
  - Existing Transaction: It uses the existing transaction
  - No Existing Transaction: It creates transaction
  - Exception: Everything rollback if exception occurs

  ### 2- REQUIRES_NEW - Always create new transaction
  - Existing Transaction: suspend existing transaction and create new transaction
  - No Existing Transaction: create new transaction
  - Exception: Only the transaction rollback where exception occurs

  ### 3- MANDATORY - must have transaction
  - Existing Transaction: uses existing transaction
  - No Existing Transaction: throw exception

  ### 4 -NEVER - must not have transaction
  - Existing Transaction: throw exception
  - No Existing Transaction: Don't create transaction, run without transaction

  ### 5- SUPPORT - runs with or without transaction
  - Existing Transaction: It uses the existing transaction
  - No Existing Transaction: Don't create transaction, run without transaction

  ### 6- NOT_SUPPORTED - runs without transaction
  - Existing Transaction: suspend existing transaction, run without transaction
  - No Existing Transaction: Don't create transaction, run without transaction

  ### 7- NESTED - create transaction within another transaction.
  - Existing Transaction: create new transaction
  - No Existing Transaction: create new transaction
  - Exception: Exception in nested transaction won't roll back enclosed transaction but error in enclosed transaction can roll back everything.

![Propagation.png](src%2Fmain%2Fresources%2FPropagation.png)

