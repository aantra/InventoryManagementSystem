## Problem Statement ##

Many e-commerce platforms provide search options to search for a specific product in their inventory. Customers enter a keyword in the search option box and get corresponding products.

Code an inventory search system where users would enter a specific keyword and all matching products for the same in inventory has to be returned. If no matching products are found, we should get an empty response.

Everything has to be in-memory but candidates are free to implement anything in configs ( yaml / json / txt etc )

Question is a 2 part problem and code for the same is expected:

:: Inventory management ( adding / modifying / deleting from inventory )
:: Inventory Search - searching in inventory above

Candidates are expected to come up with the right set of Classes / Entities to code a robust production level code with a proper search functionality.
For sake of simplicity, inventory can be limited to Electronics and Apparels but code should be in manner that adding more categories should be easy ( in other words, code SHOULD be easily extensible )

Eg:

Keyword:- Red
**Matching products: **

:: Redmi Note 8 (Neptune Blue, 4GB RAM, 64GB Storage)
:: Red Mobile Cases

Expectations:

:: Runnable code
:: OOPs / OOD principals with proper Separation of concerns
:: Testability
:: Code readability
:: Language proficiency
:: Test Cases ( bonus points )

Extension Problem ( attempt only if main part has been solved ):

Assume Sony and LG are competitors selling android mobile phones on this platform.
Sony wants to run a campaign where anyone searching for android get to see Sony phones first, can we implement a weightage mechanism where search results are weighted based on certain criteria ( say, sony wants android, pepe jeans wants to promote there denim jeans etc )

Candidates are free to come up with there own criteria, not necessarily be limited to just SONY or PEPE

[execution time limit] 1 seconds (cpp)