**Liquibase**
        
    "Version Control for your Database."  Liquibase tracks changes to your database schema.


**Workflow**

* Changelog - "source of truth" file(XML, YAML, JSON, or SQL). (table creation, column updates, etc.) in order.
* Changesets - individual units of work within the Changelog. Each changeset has an id and an author.
* DATABASECHANGELOG - The Tracking Table - When you run Liquibase, it looks at a special table it created in your database. It checks:
  * If No: It executes the SQL and records the success in the tracking table. 
  * If Yes: It skips it and moves to the next one.


**Core Architecture**

* Liquibase Core: engine that parses your files and manages the logic
* Database Drivers (JDBC): Liquibase doesn't talk to the DB directly; it uses standard JDBC drivers to communicate with MySQL, PostgreSQL, Oracle, etc.
* The "Snapshot": Before doing anything, Liquibase takes a virtual snapshot of your current database state to understand what needs to be updated.


**Design Patterns Used**

* Command Pattern
* Strategy Pattern
* State Pattern
* Adapter Pattern