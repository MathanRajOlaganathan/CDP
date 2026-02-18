**Functional**

1. Customer Management (CRUD)
   2. CRU
   3. Search by ES
   4. Archive (soft delete)
2. Person and Company Details
   3. CRU
   4. Enforce 1‑to‑1 relationship with customer
3. Contact Management
   4. Add/update contact details (email, phone, etc.)
   5. Mark a contact as primary 
   6. Mark a contact as verified/unverified 
   7. Retrieve all contacts for a customer
4. Address Management
   5. Add/update addresses 
   6. Mark an address as primary 
   7. Retrieve all addresses for a customer
5. KYC Management
   6. Add/update kyc
   7. Update KYC status (PENDING, VERIFIED, FAILED, EXPIRED)
   8. Retrieve KYC history for a customer
6. Portfolio Management
   7. Create/update portfolio entries 
   8. Retrieve all portfolios for a customer
7. Login Metadata
   8. (Not authentication — metadata only)
   9. Update login status 
   10. Update last_login_at 
   11. Track failed login attempts
8. Event Publishing
   9. Every create/update operation must:
   10. Persist to relational DB 
   11. Write an entry to event_outbox 
   12. Background publisher pushes events to Kafka 
9. Kafka Event Model 
   10. Topic per entity (e.g., cdp.customer.v1, cdp.address.v1)
   11. Event envelope with metadata + payload 
   12. Event types: CREATED, UPDATED, ARCHIVED
10. Downstream Integrations 
    11. Kafka Connect → BigQuery (raw tables)
    12. Kafka topic → Elasticsearch (search index)
    13. dbt → curated models + Customer 360



**Non‑Functional Requirements (NFR)**

1. Performance
   2. API response time < 200ms for CRUD operations 
   3. Kafka publishing latency < 1s (via outbox)
   4. Search queries < 100ms (Elasticsearch)
2. Scalability
   3. Horizontal scaling of microservices (GKE)
   4. Kafka partitions sized by customer_id
   5. BigQuery auto‑scales for analytics
   6. Elasticsearch cluster scalable by shards
3. Reliability
   4. Outbox pattern ensures exactly‑once event publishing 
   5. Retry + DLQ for Kafka failures 
   6. Zero data loss guarantee for customer events
4. Availability
   5. Target: 99.9% uptime
   6. Multi‑zone GKE deployment
   7. Managed DB (Cloud SQL) with HA
5. Security
   6. OAuth2/JWT for API authentication
   7. RBAC for admin vs service accounts
   8. PII encryption at rest (DB + ES)
   9. TLS everywhere (internal + external)
6. Auditability
   7. Every table has:
      8. created_at 
      9. created_by 
      10. updated_at 
      11. updated_by
   13. Every event has:
       14. event_id 
       15. event_type 
       16. entity_type 
       17. entity_version
       18. trace_id
7. Observability
   8. Structured logs (JSON)
   9. Distributed tracing (OpenTelemetry)
   10. Metrics (Prometheus)
   11. Dashboards (Grafana)
   12. Alerts (PagerDuty)
8. Data Governance
   9. BigQuery raw → staging → curated → marts 
   10. dbt tests for:
       11. uniqueness 
       12. referential integrity 
       13. null checks 
   14. Data lineage via dbt docs
9. Maintainability
   10. Clean modular code structure 
   11. Liquibase for schema migrations 
   12. Versioned API contracts (OpenAPI)
   13. Versioned Kafka schemas
10. Extensibility
    11. New entities can be added easily 
    12. New event types can be introduced without breaking consumers 
    13. New downstream sinks (Snowflake, Redis) can be added via Kafka Connect
   


    