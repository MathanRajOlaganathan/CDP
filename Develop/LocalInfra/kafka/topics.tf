# Common settings for all topics
locals {
  default_partitions      = 3
  default_replication     = 1
  default_cleanup_policy  = "delete"
}

resource "kafka_topic" "cdp_customer_v1" {
  name               = "cdp.customer.v1"
  partitions         = local.default_partitions
  replication_factor = local.default_replication

  config = {
    "cleanup.policy" = local.default_cleanup_policy
  }
}

resource "kafka_topic" "cdp_person_v1" {
  name               = "cdp.person.v1"
  partitions         = local.default_partitions
  replication_factor = local.default_replication

  config = {
    "cleanup.policy" = local.default_cleanup_policy
  }
}

resource "kafka_topic" "cdp_company_v1" {
  name               = "cdp.company.v1"
  partitions         = local.default_partitions
  replication_factor = local.default_replication

  config = {
    "cleanup.policy" = local.default_cleanup_policy
  }
}

resource "kafka_topic" "cdp_address_v1" {
  name               = "cdp.address.v1"
  partitions         = local.default_partitions
  replication_factor = local.default_replication

  config = {
    "cleanup.policy" = local.default_cleanup_policy
  }
}

resource "kafka_topic" "cdp_contact_v1" {
  name               = "cdp.contact.v1"
  partitions         = local.default_partitions
  replication_factor = local.default_replication

  config = {
    "cleanup.policy" = local.default_cleanup_policy
  }
}

resource "kafka_topic" "cdp_kyc_v1" {
  name               = "cdp.kyc.v1"
  partitions         = local.default_partitions
  replication_factor = local.default_replication

  config = {
    "cleanup.policy" = local.default_cleanup_policy
  }
}

resource "kafka_topic" "cdp_portfolio_v1" {
  name               = "cdp.portfolio.v1"
  partitions         = local.default_partitions
  replication_factor = local.default_replication

  config = {
    "cleanup.policy" = local.default_cleanup_policy
  }
}

resource "kafka_topic" "cdp_login_v1" {
  name               = "cdp.login.v1"
  partitions         = local.default_partitions
  replication_factor = local.default_replication

  config = {
    "cleanup.policy" = local.default_cleanup_policy
  }
}
