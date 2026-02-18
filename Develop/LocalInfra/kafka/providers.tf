terraform {
  required_version = ">= 1.3.0"

  required_providers {
    kafka = {
      source  = "Mongey/kafka"
      version = "~> 0.5"
    }
  }
}



provider "kafka" {
  bootstrap_servers = ["localhost:19092"]
  tls_enabled = false
}


