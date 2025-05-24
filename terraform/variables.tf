variable "aws_region" {
  default = "us-east-1"
}

variable "key_name" {}
variable "public_key_path" {}
variable "ec2_ami" {}
variable "instance_type" {
  default = "t2.micro"
}

variable "db_name" {}
variable "db_user" {}
variable "db_password" {}
variable "db_host" {
  default = "localhost"
}
