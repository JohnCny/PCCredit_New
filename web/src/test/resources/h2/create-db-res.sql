DROP TABLE IF EXISTS b_application;
CREATE TABLE b_application (
  id int(11) NOT NULL AUTO_INCREMENT,
  customer_id int(11) DEFAULT NULL,
  manager_id int(11) DEFAULT NULL,
  loan_id int(11) DEFAULT NULL ,
  status tinyint(1) DEFAULT NULL ,
  monthly_payment decimal(20,6) DEFAULT NULL ,
  model_evaluation varchar(64) DEFAULT NULL ,
  repayment_status tinyint(1) DEFAULT NULL ,
  PRIMARY KEY (id),
  KEY application_loan_idx72 (loan_id) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for b_blacklist
-- ----------------------------
DROP TABLE IF EXISTS b_blacklist;
CREATE TABLE b_blacklist (
  id int(11) NOT NULL,
  type varchar(64) DEFAULT NULL ,
  name varchar(32) DEFAULT NULL ,
  id_number varchar(32) DEFAULT NULL ,
  tel varchar(32) DEFAULT NULL ,
  phone varchar(32) DEFAULT NULL ,
  home_address varchar(128) DEFAULT NULL ,
  company_name varchar(32) DEFAULT NULL ,
  company_phone varchar(32) DEFAULT NULL ,
  company_address varchar(32) DEFAULT NULL ,
  created_by varchar(32) DEFAULT NULL,
  created_at datetime DEFAULT NULL,
  modified_by varchar(32) DEFAULT NULL,
  modified_at timestamp NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for b_customer_account
-- ----------------------------
DROP TABLE IF EXISTS b_customer_account;
CREATE TABLE b_customer_account (
  id int(11) NOT NULL AUTO_INCREMENT,
  customer_id int(11) DEFAULT NULL,
  bank varchar(64) DEFAULT NULL,
  account bigint(20) DEFAULT NULL,
  created_at datetime DEFAULT NULL,
  modified_by timestamp NULL ,
  text1 varchar(32) DEFAULT NULL,
  text2 varchar(32) DEFAULT NULL,
  text3 varchar(32) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for b_customer_others
-- ----------------------------
DROP TABLE IF EXISTS b_customer_others;
CREATE TABLE b_customer_others (
  id int(11) NOT NULL AUTO_INCREMENT,
  family_income int(11) DEFAULT NULL ,
  family_net_assets int(11) DEFAULT NULL ,
  tax int(11) DEFAULT NULL ,
  insurance int(11) DEFAULT NULL ,
  commercial_credit int(11) DEFAULT NULL ,
  illegal_records int(11) DEFAULT NULL ,
  customer_id int(11) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for b_customer_pictures
-- ----------------------------
DROP TABLE IF EXISTS b_customer_pictures;
CREATE TABLE b_customer_pictures (
  id int(32) NOT NULL AUTO_INCREMENT,
  customer_id int(11) NOT NULL ,
  picture_path varchar(128) DEFAULT NULL ,
  created_at datetime DEFAULT NULL,
  modified_at timestamp NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for b_customer_relationship
-- ----------------------------
DROP TABLE IF EXISTS b_customer_relationship;
CREATE TABLE b_customer_relationship (
  id int(11) NOT NULL AUTO_INCREMENT,
  customer_id int(11) NOT NULL,
  r_name varchar(32) DEFAULT NULL ,
  r_phone varchar(32) DEFAULT NULL ,
  r_tel varchar(32) DEFAULT NULL ,
  r_relationship tinyint(4) DEFAULT NULL ,
  o_name varchar(32) DEFAULT NULL ,
  o_phone varchar(32) DEFAULT NULL ,
  o_tel varchar(32) DEFAULT NULL ,
  o_relationship tinyint(4) DEFAULT NULL ,
  created_at datetime DEFAULT NULL,
  modified_at timestamp NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for b_loan
-- ----------------------------
DROP TABLE IF EXISTS b_loan;
CREATE TABLE b_loan (
  id int(11) NOT NULL AUTO_INCREMENT,
  user_id int(11) DEFAULT NULL ,
  loan_term int(11) DEFAULT NULL ,
  loan_amount decimal(10,2) DEFAULT NULL ,
  apply_date date DEFAULT NULL ,
  repayment_date date DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for b_repayment_plan
-- ----------------------------
DROP TABLE IF EXISTS b_repayment_plan;
CREATE TABLE b_repayment_plan (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL ,
  status tinyint(2) DEFAULT NULL ,
  repay_date timestamp NULL DEFAULT NULL ,
  loan_term varchar(32) DEFAULT NULL ,
  monthly_payment varchar(32) DEFAULT NULL ,
  real_repay_date timestamp NULL DEFAULT NULL ,
  PRIMARY KEY (id),
  KEY repayment_applicatin_fk_idx73 (application_id) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_antifraud_result
-- ----------------------------
DROP TABLE IF EXISTS t_antifraud_result;
CREATE TABLE t_antifraud_result (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL ,
  code varchar(64) DEFAULT NULL ,
  result varchar(1024) DEFAULT NULL ,
  time datetime DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_application_attachment
-- ----------------------------
DROP TABLE IF EXISTS t_application_attachment;
CREATE TABLE t_application_attachment (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL,
  server_url_path varchar(64) DEFAULT NULL,
  image_type varchar(64) DEFAULT NULL ,
  file_path varchar(255) DEFAULT NULL ,
  remark varchar(128) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL,
  created_at datetime DEFAULT NULL,
  modified_by int(11) DEFAULT NULL,
  modified_at timestamp NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_application_car
-- ----------------------------
DROP TABLE IF EXISTS t_application_car;
CREATE TABLE t_application_car (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL,
  brand varchar(128) DEFAULT NULL ,
  license varchar(64) DEFAULT NULL ,
  date date DEFAULT NULL ,
  cost decimal(12,2) DEFAULT NULL ,
  value decimal(12,2) DEFAULT NULL ,
  conditions varchar(255) DEFAULT NULL ,
  remark varchar(255) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL,
  created_at datetime DEFAULT NULL,
  modified_by int(11) DEFAULT NULL,
  modified_at timestamp NULL ,
  mark tinyint(1) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_application_guarantor
-- ----------------------------
DROP TABLE IF EXISTS t_application_guarantor;
CREATE TABLE t_application_guarantor (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL ,
  guarantor varchar(255) DEFAULT NULL ,
  sex tinyint(2) DEFAULT NULL ,
  relationship varchar(32) DEFAULT NULL ,
  organization_name varchar(32) DEFAULT NULL ,
  department_name varchar(32) DEFAULT NULL ,
  contact_phone varchar(32) DEFAULT NULL ,
  cell_phone varchar(32) DEFAULT NULL ,
  document_id varchar(32) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL,
  created_at datetime DEFAULT NULL,
  modified_by int(11) DEFAULT NULL,
  modified_at timestamp NULL ,
  home_address varchar(128) DEFAULT NULL ,
  income_year decimal(10,2) DEFAULT NULL ,
  gurantor varchar(255) DEFAULT NULL ,
  type varchar(255) DEFAULT NULL ,
  position varchar(255) DEFAULT NULL ,
  main_assets varchar(128) DEFAULT NULL ,
  remark varchar(255) DEFAULT NULL ,
  comment varchar(1024) DEFAULT NULL,
  work_address varchar(255) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=251 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_application_house
-- ----------------------------
DROP TABLE IF EXISTS t_application_house;
CREATE TABLE t_application_house (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL,
  address varchar(128) DEFAULT NULL ,
  date date DEFAULT NULL ,
  cost decimal(16,2) DEFAULT NULL ,
  value decimal(16,2) DEFAULT NULL ,
  property_license varchar(64) DEFAULT NULL ,
  condition varchar(255) DEFAULT NULL ,
  remark varchar(255) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL,
  created_at datetime DEFAULT NULL,
  modified_by int(11) DEFAULT NULL,
  modified_at timestamp NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_application_log
-- ----------------------------
DROP TABLE IF EXISTS t_application_log;
CREATE TABLE t_application_log (
  id bigint(20) NOT NULL AUTO_INCREMENT ,
  customer_id bigint(20) DEFAULT NULL ,
  application_id bigint(20) DEFAULT NULL ,
  operation_name varchar(1000) DEFAULT NULL ,
  content varchar(1000) DEFAULT NULL ,
  created_at datetime(6) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_application_var
-- ----------------------------
DROP TABLE IF EXISTS t_application_var;
CREATE TABLE t_application_var (
  id int(11) NOT NULL AUTO_INCREMENT,
  aid int(11) DEFAULT NULL ,
  vid int(11) DEFAULT NULL ,
  value varchar(255) DEFAULT NULL ,
  option_id int(11) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY aid80 (aid) USING BTREE,
  KEY vid81 (vid) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=680877 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_b_assets
-- ----------------------------
DROP TABLE IF EXISTS t_b_assets;
CREATE TABLE t_b_assets (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL,
  name varchar(255) DEFAULT NULL ,
  value decimal(16,2) DEFAULT NULL ,
  remark varchar(255) DEFAULT NULL ,
  mark tinyint(1) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_b_contingent_liability
-- ----------------------------
DROP TABLE IF EXISTS t_b_contingent_liability;
CREATE TABLE t_b_contingent_liability (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL,
  name varchar(255) DEFAULT NULL ,
  value decimal(16,2) DEFAULT NULL ,
  remark varchar(255) DEFAULT NULL,
  mark tinyint(1) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_b_current_assets
-- ----------------------------
DROP TABLE IF EXISTS t_b_current_assets;
CREATE TABLE t_b_current_assets (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  value decimal(16,2) DEFAULT NULL,
  remark varchar(255) DEFAULT NULL,
  mark tinyint(1) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_b_current_liabilities
-- ----------------------------
DROP TABLE IF EXISTS t_b_current_liabilities;
CREATE TABLE t_b_current_liabilities (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  value decimal(16,2) DEFAULT NULL,
  remark varchar(255) DEFAULT NULL,
  mark tinyint(1) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_b_fixed_assets
-- ----------------------------
DROP TABLE IF EXISTS t_b_fixed_assets;
CREATE TABLE t_b_fixed_assets (
  id int(11) NOT NULL,
  application_id int(11) DEFAULT NULL,
  name varchar(255) DEFAULT NULL ,
  value decimal(16,2) DEFAULT NULL ,
  remark varchar(255) DEFAULT NULL,
  mark tinyint(1) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_b_liability
-- ----------------------------
DROP TABLE IF EXISTS t_b_liability;
CREATE TABLE t_b_liability (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  value decimal(16,2) DEFAULT NULL,
  remark varchar(255) DEFAULT NULL,
  mark tinyint(1) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_b_liability_owners_equity
-- ----------------------------
DROP TABLE IF EXISTS t_b_liability_owners_equity;
CREATE TABLE t_b_liability_owners_equity (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL,
  name varchar(255) DEFAULT NULL ,
  value decimal(16,2) DEFAULT NULL ,
  remark varchar(255) DEFAULT NULL,
  mark tinyint(1) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_b_longterm_liabilities
-- ----------------------------
DROP TABLE IF EXISTS t_b_longterm_liabilities;
CREATE TABLE t_b_longterm_liabilities (
  id int(11) NOT NULL,
  application_id int(11) DEFAULT NULL,
  name varchar(255) DEFAULT NULL ,
  value decimal(16,2) DEFAULT NULL ,
  remark varchar(255) DEFAULT NULL,
  mark tinyint(1) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_b_other_assets
-- ----------------------------
DROP TABLE IF EXISTS t_b_other_assets;
CREATE TABLE t_b_other_assets (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL,
  name varchar(255) DEFAULT NULL ,
  value decimal(16,2) DEFAULT NULL ,
  remark varchar(255) DEFAULT NULL,
  mark tinyint(1) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_b_other_liability
-- ----------------------------
DROP TABLE IF EXISTS t_b_other_liability;
CREATE TABLE t_b_other_liability (
  id int(11) NOT NULL,
  application_id int(11) DEFAULT NULL,
  name varchar(255) DEFAULT NULL ,
  value decimal(16,2) DEFAULT NULL ,
  remark varchar(255) DEFAULT NULL,
  mark tinyint(1) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_b_owners_equity
-- ----------------------------
DROP TABLE IF EXISTS t_b_owners_equity;
CREATE TABLE t_b_owners_equity (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL,
  name varchar(255) DEFAULT NULL ,
  value decimal(16,2) DEFAULT NULL ,
  remark varchar(255) DEFAULT NULL,
  mark tinyint(1) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_balance
-- ----------------------------
DROP TABLE IF EXISTS t_balance;
CREATE TABLE t_balance (
  id int(11) NOT NULL AUTO_INCREMENT ,
  var_description varchar(16) DEFAULT NULL ,
  type varchar(16) DEFAULT NULL ,
  input_type varchar(16) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_balance_spc
-- ----------------------------
DROP TABLE IF EXISTS t_balance_spc;
CREATE TABLE t_balance_spc (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL,
  subject varchar(255) DEFAULT NULL ,
  subproject varchar(255) DEFAULT NULL,
  value double DEFAULT NULL ,
  prior double DEFAULT NULL,
  proportion double DEFAULT NULL,
  comment varchar(255) DEFAULT NULL,
  remark varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=2058 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_balance_var
-- ----------------------------
DROP TABLE IF EXISTS t_balance_var;
CREATE TABLE t_balance_var (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL ,
  var_id int(11) DEFAULT NULL ,
  value varchar(255) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=417891 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_bank_statements
-- ----------------------------
DROP TABLE IF EXISTS t_bank_statements;
CREATE TABLE t_bank_statements (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL ,
  subject varchar(16) DEFAULT NULL ,
  jan decimal(8,2) DEFAULT NULL ,
  feb decimal(8,2) DEFAULT NULL ,
  mar decimal(8,2) DEFAULT NULL ,
  apr decimal(8,2) DEFAULT NULL ,
  may decimal(8,2) DEFAULT NULL ,
  jun decimal(8,2) DEFAULT NULL ,
  jul decimal(8,2) DEFAULT NULL ,
  aug decimal(8,2) DEFAULT NULL ,
  sep decimal(8,2) DEFAULT NULL ,
  oct decimal(8,2) DEFAULT NULL ,
  nov decimal(8,2) DEFAULT NULL ,
  dec decimal(8,2) DEFAULT NULL ,
  ananlysis varchar(1024) DEFAULT NULL ,
  comment varchar(1024) DEFAULT NULL ,
  mark tinyint(1) DEFAULT NULL ,
  sum decimal(10,2) DEFAULT NULL ,
  avg varchar(255) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=62416 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_bank_statements_attached
-- ----------------------------
DROP TABLE IF EXISTS t_bank_statements_attached;
CREATE TABLE t_bank_statements_attached (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL ,
  subject varchar(16) DEFAULT NULL ,
  jan decimal(8,2) DEFAULT NULL ,
  feb decimal(8,2) DEFAULT NULL ,
  mar decimal(8,2) DEFAULT NULL ,
  apr decimal(8,2) DEFAULT NULL ,
  may decimal(8,2) DEFAULT NULL ,
  jun decimal(8,2) DEFAULT NULL ,
  jul decimal(8,2) DEFAULT NULL ,
  aug decimal(8,2) DEFAULT NULL ,
  sep decimal(8,2) DEFAULT NULL ,
  oct decimal(8,2) DEFAULT NULL ,
  nov decimal(8,2) DEFAULT NULL ,
  dec decimal(8,2) DEFAULT NULL ,
  ananlysis varchar(1024) DEFAULT NULL ,
  sum varchar(32) DEFAULT NULL ,
  competitor varchar(16) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=574 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_blacklist_result
-- ----------------------------
DROP TABLE IF EXISTS t_blacklist_result;
CREATE TABLE t_blacklist_result (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL ,
  code varchar(64) DEFAULT NULL ,
  result varchar(1024) DEFAULT NULL ,
  time datetime DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_capitalsource_plan
-- ----------------------------
DROP TABLE IF EXISTS t_capitalsource_plan;
CREATE TABLE t_capitalsource_plan (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL,
  plan varchar(255) DEFAULT NULL ,
  amount decimal(16,2) DEFAULT NULL,
  remark varchar(255) DEFAULT NULL ,
  comment varchar(255) DEFAULT NULL ,
  mark tinyint(4) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 ;

-- ----------------------------
-- Table structure for t_cash_flow
-- ----------------------------
DROP TABLE IF EXISTS t_cash_flow;
CREATE TABLE t_cash_flow (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL ,
  subject varchar(32) DEFAULT NULL ,
  jan varchar(32) DEFAULT NULL ,
  feb varchar(32) DEFAULT NULL ,
  mar varchar(32) DEFAULT NULL ,
  apr varchar(32) DEFAULT NULL ,
  may varchar(32) DEFAULT NULL ,
  jun varchar(32) DEFAULT NULL ,
  jul varchar(32) DEFAULT NULL ,
  aug varchar(32) DEFAULT NULL ,
  sep varchar(32) DEFAULT NULL ,
  oct varchar(32) DEFAULT NULL ,
  nov varchar(32) DEFAULT NULL ,
  dec varchar(32) DEFAULT NULL ,
  sum varchar(32) DEFAULT NULL,
  comment varchar(1024) DEFAULT NULL ,
  survey_date varchar(32) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=167040 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_collection_case_over
-- ----------------------------
DROP TABLE IF EXISTS t_collection_case_over;
CREATE TABLE t_collection_case_over (
  id int(11) NOT NULL AUTO_INCREMENT,
  customer_id int(11) NOT NULL ,
  manager_id int(11) NOT NULL ,
  divisional_result varchar(255) DEFAULT NULL ,
  divisional_time varchar(16) DEFAULT NULL ,
  original_organization_id int(11) DEFAULT NULL ,
  original_manager_id int(11) DEFAULT NULL ,
  current_organization_id int(11) DEFAULT NULL ,
  divisional_progress varchar(16) DEFAULT NULL ,
  divisional_type varchar(16) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL ,
  created_at datetime DEFAULT NULL ,
  modified_by int(11) DEFAULT NULL ,
  modified_at timestamp NULL  ,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_collection_plan
-- ----------------------------
DROP TABLE IF EXISTS t_collection_plan;
CREATE TABLE t_collection_plan (
  id int(11) NOT NULL AUTO_INCREMENT,
  customer_id int(11) DEFAULT NULL ,
  product_id int(11) DEFAULT NULL ,
  implementation_objective varchar(32) DEFAULT NULL ,
  end_result varchar(32) DEFAULT NULL ,
  collection_time varchar(32) DEFAULT NULL ,
  collection_method varchar(32) DEFAULT NULL ,
  collection_promise_date varchar(32) DEFAULT NULL ,
  collection_endtime varchar(32) DEFAULT NULL ,
  collection_amount varchar(32) DEFAULT NULL ,
  manager_id int(11) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL ,
  created_at datetime DEFAULT NULL ,
  modified_by int(11) DEFAULT NULL ,
  modified_at timestamp NULL  ,
  created_way varchar(32) DEFAULT NULL ,
  loan_id int(11) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_collection_plans_action
-- ----------------------------
DROP TABLE IF EXISTS t_collection_plans_action;
CREATE TABLE t_collection_plans_action (
  id int(11) NOT NULL AUTO_INCREMENT,
  collection_plan_id int(11) NOT NULL ,
  collection_way varchar(32) DEFAULT NULL ,
  collection_result varchar(32) DEFAULT NULL ,
  collection_start_time varchar(32) DEFAULT NULL ,
  collection_end_time varchar(32) DEFAULT NULL ,
  if_implement varchar(32) DEFAULT NULL ,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE82 (id) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for t_cross_checking
-- ----------------------------
DROP TABLE IF EXISTS t_cross_checking;
CREATE TABLE t_cross_checking (
  id int(11) NOT NULL AUTO_INCREMENT,
  var_id int(11) DEFAULT NULL ,
  var_name varchar(32) DEFAULT NULL ,
  type varchar(16) DEFAULT 'string' ,
  input_type varchar(16) DEFAULT 'text' ,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_cross_checking_attached
-- ----------------------------
DROP TABLE IF EXISTS t_cross_checking_attached;
CREATE TABLE t_cross_checking_attached (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(32) DEFAULT NULL ,
  purchase_price decimal(11,2) DEFAULT NULL ,
  selling_price decimal(11,2) DEFAULT NULL ,
  profit decimal(11,0) DEFAULT NULL ,
  sales_ratio double DEFAULT NULL ,
  gross_margin double DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_cross_checking_var
-- ----------------------------
DROP TABLE IF EXISTS t_cross_checking_var;
CREATE TABLE t_cross_checking_var (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL ,
  var_id int(11) DEFAULT NULL ,
  value varchar(1024) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=157 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_customer
-- ----------------------------
DROP TABLE IF EXISTS t_customer;
CREATE TABLE t_customer (
  id int(11) NOT NULL AUTO_INCREMENT,
  code varchar(32) NOT NULL ,
  cname varchar(50) NOT NULL ,
  nationality varchar(16) DEFAULT NULL ,
  sex tinyint(1) DEFAULT NULL ,
  certificate_type varchar(32) DEFAULT NULL ,
  id_number varchar(18) DEFAULT NULL ,
  home_address varchar(64) DEFAULT NULL ,
  zip_code varchar(16) DEFAULT NULL ,
  tel varchar(18) DEFAULT NULL ,
  email varchar(64) DEFAULT NULL ,
  type_of_residence varchar(16) DEFAULT NULL ,
  marriage varchar(8) DEFAULT NULL ,
  eduction varchar(8) DEFAULT NULL ,
  residence_address varchar(64) DEFAULT NULL ,
  manager_id int(11) DEFAULT NULL ,
  if_legal_person tinyint(1) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL ,
  created_at datetime DEFAULT NULL ,
  modified_by int(11) DEFAULT NULL ,
  modified_at timestamp NULL  ,
  is_deleted tinyint(1) DEFAULT NULL ,
  if_have_household_booklet tinyint(1) DEFAULT NULL ,
  issued_date date DEFAULT NULL ,
  issued_authority varchar(64) DEFAULT NULL ,
  if_enduring tinyint(1) DEFAULT NULL ,
  expirty_date date DEFAULT NULL ,
  management_feature tinyint(2) DEFAULT NULL ,
  area_address varchar(64) DEFAULT NULL ,
  born_date datetime DEFAULT NULL ,
  self_employed_store_name varchar(64) DEFAULT NULL ,
  self_employed_business_license varchar(32) DEFAULT NULL ,
  on_update_business_license date DEFAULT NULL ,
  store_address varchar(64) DEFAULT NULL ,
  specific_home_address varchar(255) DEFAULT NULL ,
  census_reside varchar(255) DEFAULT NULL ,
  living_time int(11) DEFAULT NULL ,
  main_assets varchar(255) DEFAULT NULL ,
  user_id int(11) DEFAULT NULL,
  status int(11) DEFAULT '0' ,
  social_security_id varchar(50) DEFAULT NULL ,
  PRIMARY KEY (id),
  UNIQUE KEY index283 (code) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=27235 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_customer_account
-- ----------------------------
DROP TABLE IF EXISTS t_customer_account;
CREATE TABLE t_customer_account (
  id int(11) NOT NULL AUTO_INCREMENT,
  customer_id int(11) DEFAULT NULL,
  bank varchar(64) DEFAULT NULL,
  account varchar(20) DEFAULT NULL,
  created_at datetime DEFAULT NULL,
  modified_by timestamp NULL ,
  text1 varchar(32) DEFAULT NULL,
  text2 varchar(32) DEFAULT NULL,
  text3 varchar(32) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=431 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_customer_account_information
-- ----------------------------
DROP TABLE IF EXISTS t_customer_account_information;
CREATE TABLE t_customer_account_information (
  id int(11) NOT NULL AUTO_INCREMENT,
  customer_id int(11) NOT NULL,
  account_status tinyint(1) DEFAULT NULL ,
  overdue_amount decimal(10,2) DEFAULT NULL ,
  table_turn_pay decimal(10,2) DEFAULT NULL ,
  compound_amount decimal(10,2) DEFAULT NULL ,
  current_period_pay decimal(10,2) DEFAULT NULL ,
  verification_code int(11) DEFAULT NULL ,
  current_period_annuity decimal(10,2) DEFAULT NULL ,
  card_number bigint(20) DEFAULT NULL ,
  current_period_overdue_pay decimal(10,2) DEFAULT NULL ,
  current_period_cash decimal(10,2) DEFAULT NULL ,
  current_period_scale double DEFAULT NULL ,
  account_status_date date DEFAULT NULL ,
  account_change_amount decimal(10,0) DEFAULT NULL ,
  credit_amount decimal(10,0) DEFAULT NULL ,
  amount_profits_inreturn decimal(10,0) DEFAULT NULL ,
  reimbursement_deadline date DEFAULT NULL ,
  statement_date date DEFAULT NULL ,
  debit_amount_adjustment decimal(10,2) DEFAULT NULL ,
  consumption_logo varchar(32) DEFAULT NULL ,
  compound_interest_receivable decimal(10,2) DEFAULT NULL ,
  interest_receivable decimal(10,2) DEFAULT NULL ,
  accrued_interest_compound decimal(10,2) DEFAULT NULL ,
  current_period_accrued decimal(10,2) DEFAULT NULL ,
  current_should_compounded decimal(10,2) DEFAULT NULL ,
  next_interest_receivable decimal(10,2) DEFAULT NULL ,
  recent_interest_date date DEFAULT NULL ,
  last_payment_date date DEFAULT NULL ,
  amount_installment_payment decimal(10,2) DEFAULT NULL ,
  installment_total_amount decimal(10,2) DEFAULT NULL ,
  payment_installment_credit decimal(10,2) DEFAULT NULL ,
  staging_remaining_principal decimal(10,2) DEFAULT NULL ,
  overdue_total_number int(11) DEFAULT NULL ,
  repayment_accont_period int(11) DEFAULT NULL ,
  consumption_account_period int(11) DEFAULT NULL ,
  transantion_account int(11) DEFAULT NULL ,
  account_queue_date date DEFAULT NULL ,
  amount_other_costs decimal(10,2) DEFAULT NULL ,
  amount_controversy decimal(10,2) DEFAULT NULL ,
  pre_period_account decimal(10,2) DEFAULT NULL ,
  recent_lowest_bill decimal(10,2) DEFAULT NULL ,
  overdue_time int(11) DEFAULT NULL ,
  temp_amount decimal(10,2) DEFAULT NULL ,
  temp_effective_date date DEFAULT NULL ,
  temp_expiration_date date DEFAULT NULL ,
  charge_logo varchar(32) DEFAULT NULL ,
  account_number bigint(20) DEFAULT NULL ,
  aging int(11) DEFAULT NULL ,
  principal_overdraft decimal(10,2) DEFAULT NULL ,
  total_amount_overdraft decimal(10,2) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL,
  created_at datetime DEFAULT NULL,
  modified_by int(11) DEFAULT NULL,
  modified_time timestamp NULL ,
  PRIMARY KEY (id),
  UNIQUE KEY customer_id_UNIQUE84 (customer_id) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_customer_amount_adjustment
-- ----------------------------
DROP TABLE IF EXISTS t_customer_amount_adjustment;
CREATE TABLE t_customer_amount_adjustment (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL ,
  actual_amount decimal(10,2) DEFAULT NULL ,
  assess_amount decimal(10,2) DEFAULT NULL ,
  approval_amount decimal(10,2) DEFAULT NULL ,
  original_amoount decimal(10,2) DEFAULT NULL ,
  adjust_amount_time datetime DEFAULT NULL ,
  status tinyint(1) DEFAULT NULL ,
  adjustment_type tinyint(1) DEFAULT NULL ,
  serial_number varchar(32) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL,
  created_at datetime DEFAULT NULL,
  modified_by int(11) DEFAULT NULL,
  modified_at timestamp NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_customer_apply
-- ----------------------------
DROP TABLE IF EXISTS t_customer_apply;
CREATE TABLE t_customer_apply (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  customer_id int(11) NOT NULL ,
  cname varchar(255) NOT NULL ,
  sex smallint(6) DEFAULT NULL ,
  id_number varchar(255) NOT NULL ,
  home_address varchar(255) DEFAULT NULL ,
  tel varchar(255) NOT NULL ,
  product varchar(255) DEFAULT NULL ,
  apply_time datetime DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_customer_attachment
-- ----------------------------
DROP TABLE IF EXISTS t_customer_attachment;
CREATE TABLE t_customer_attachment (
  id int(11) NOT NULL AUTO_INCREMENT,
  customer_id int(11) DEFAULT NULL,
  server_url_path varchar(64) DEFAULT NULL,
  image_type varchar(64) DEFAULT NULL ,
  file_path varchar(255) DEFAULT NULL ,
  remark varchar(128) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL,
  created_at datetime DEFAULT NULL,
  modified_by int(11) DEFAULT NULL,
  modified_at timestamp NULL ,
  type int(11) DEFAULT NULL ,
  subtype int(11) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=801 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_customer_business_information
-- ----------------------------
DROP TABLE IF EXISTS t_customer_business_information;
CREATE TABLE t_customer_business_information (
  id int(11) NOT NULL AUTO_INCREMENT,
  customer_id int(11) NOT NULL,
  store_name varchar(64) DEFAULT NULL ,
  organization_type tinyint(2) DEFAULT NULL ,
  store_area int(11) DEFAULT NULL ,
  legal_representative varchar(32) DEFAULT NULL ,
  actual_controller varchar(32) DEFAULT NULL ,
  shareholders_in_shares varchar(255) DEFAULT NULL ,
  main_business_scope varchar(128) DEFAULT NULL ,
  if_business_license tinyint(1) DEFAULT NULL ,
  proof_of_business_time varchar(32) DEFAULT NULL ,
  start_date date DEFAULT NULL ,
  store_address varchar(64) DEFAULT NULL ,
  fixed_telephone varchar(15) DEFAULT NULL ,
  store_type tinyint(2) DEFAULT NULL ,
  store_decoration_condition tinyint(1) DEFAULT NULL ,
  store_enable_date date DEFAULT NULL ,
  business_account_number tinyint(3) DEFAULT NULL ,
  main_bank varchar(64) DEFAULT NULL ,
  account_number bigint(20) DEFAULT NULL ,
  bank_2 varchar(64) DEFAULT NULL ,
  account_number_2 bigint(20) DEFAULT NULL ,
  business_history_and_capital_accumulation decimal(10,2) DEFAULT NULL ,
  business_mode varchar(64) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL,
  created_at datetime DEFAULT NULL,
  modified_by int(11) DEFAULT NULL,
  modified_at timestamp NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_customer_career
-- ----------------------------
DROP TABLE IF EXISTS t_customer_career;
CREATE TABLE t_customer_career (
  id int(11) NOT NULL AUTO_INCREMENT,
  customer_id int(11) NOT NULL ,
  company_name varchar(64) DEFAULT NULL ,
  department_name varchar(16) DEFAULT NULL ,
  zip_code varchar(16) DEFAULT NULL ,
  company_phone varchar(16) DEFAULT NULL ,
  company_nature varchar(16) DEFAULT NULL ,
  industry_type varchar(16) DEFAULT NULL ,
  positio varchar(16) DEFAULT NULL ,
  title varchar(16) DEFAULT NULL ,
  annual_income decimal(15,2) DEFAULT NULL ,
  year_work_company varchar(8) DEFAULT NULL ,
  before_name_company varchar(16) DEFAULT NULL ,
  before_year_work_company varchar(16) DEFAULT NULL ,
  work_time datetime DEFAULT NULL ,
  created_by int(11) DEFAULT NULL ,
  created_at datetime DEFAULT NULL ,
  modified_by int(11) DEFAULT NULL ,
  modified_at timestamp NULL ,
  income_annual decimal(11,0) DEFAULT NULL ,
  other_income varchar(64) DEFAULT NULL ,
  income_checking varchar(1024) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for t_customer_income
-- ----------------------------
DROP TABLE IF EXISTS t_customer_income;
CREATE TABLE t_customer_income (
  id int(11) NOT NULL AUTO_INCREMENT,
  customer_id int(11) DEFAULT NULL,
  source varchar(225) DEFAULT NULL ,
  income_year decimal(10,2) DEFAULT NULL ,
  income_month decimal(10,2) DEFAULT NULL ,
  property varchar(64) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL,
  created_at datetime DEFAULT NULL,
  modified_by int(11) DEFAULT NULL,
  modified_at timestamp NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_customer_learning_history
-- ----------------------------
DROP TABLE IF EXISTS t_customer_learning_history;
CREATE TABLE t_customer_learning_history (
  id int(11) NOT NULL AUTO_INCREMENT,
  customer_id int(11) DEFAULT NULL ,
  school_name varchar(64) DEFAULT NULL ,
  admission_date date DEFAULT NULL ,
  graduation_date date DEFAULT NULL ,
  educational_background tinyint(1) DEFAULT NULL ,
  witness varchar(16) DEFAULT NULL ,
  witness_address varchar(64) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL,
  created_at datetime DEFAULT NULL,
  modified_by int(11) DEFAULT NULL,
  modified_at timestamp NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_customer_maintenance_log
-- ----------------------------
DROP TABLE IF EXISTS t_customer_maintenance_log;
CREATE TABLE t_customer_maintenance_log (
  id int(11) NOT NULL AUTO_INCREMENT,
  customer_id int(11) DEFAULT NULL,
  maintenance_personnel_id int(11) DEFAULT NULL ,
  maintenance_schedule_id int(11) DEFAULT NULL ,
  marketing_plan_id int(11) DEFAULT NULL ,
  modified_table_name varchar(32) DEFAULT NULL ,
  modified_field_name varchar(32) DEFAULT NULL ,
  modified_reason varchar(64) DEFAULT NULL ,
  original_value varchar(4096) DEFAULT NULL ,
  present_value varchar(4096) DEFAULT NULL ,
  maintenance_type tinyint(1) DEFAULT NULL ,
  created_by varchar(64) DEFAULT NULL ,
  created_at datetime DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_customer_maintenance_plan
-- ----------------------------
DROP TABLE IF EXISTS t_customer_maintenance_plan;
CREATE TABLE t_customer_maintenance_plan (
  id int(11) NOT NULL AUTO_INCREMENT,
  customer_id int(11) NOT NULL,
  manager_id int(11) NOT NULL,
  maintenance_goal varchar(64) DEFAULT NULL ,
  maintenance_way varchar(64) DEFAULT NULL ,
  maintenance_day varchar(64) DEFAULT NULL ,
  created_way varchar(32) DEFAULT NULL ,
  end_result varchar(64) DEFAULT NULL ,
  remarks_create_reason varchar(64) DEFAULT NULL ,
  maintenance_endtime datetime DEFAULT NULL ,
  created_by int(11) DEFAULT NULL,
  created_at datetime DEFAULT NULL,
  modified_by int(11) DEFAULT NULL,
  modified_at timestamp NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_customer_maintenance_plans_action
-- ----------------------------
DROP TABLE IF EXISTS t_customer_maintenance_plans_action;
CREATE TABLE t_customer_maintenance_plans_action (
  id int(11) NOT NULL AUTO_INCREMENT,
  maintenance_plan_id int(11) NOT NULL ,
  maintenance_way varchar(64) DEFAULT NULL ,
  maintenance_result varchar(64) DEFAULT NULL ,
  maintenance_start_time datetime DEFAULT NULL ,
  maintenance_end_time datetime DEFAULT NULL ,
  created_by int(11) DEFAULT NULL,
  created_at datetime DEFAULT NULL,
  modified_by int(11) DEFAULT NULL,
  modified_at timestamp NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_customer_product
-- ----------------------------
DROP TABLE IF EXISTS t_customer_product;
CREATE TABLE t_customer_product (
  customer_id int(11) NOT NULL ,
  product_id int(11) NOT NULL ,
  PRIMARY KEY (customer_id,product_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_customer_risk_list
-- ----------------------------
DROP TABLE IF EXISTS t_customer_risk_list;
CREATE TABLE t_customer_risk_list (
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  customer_id int(11) DEFAULT NULL ,
  manager_id int(11) DEFAULT NULL ,
  risk_level int(11) DEFAULT NULL ,
  risk_create_type varchar(32) DEFAULT NULL ,
  status varchar(32) DEFAULT NULL ,
  refuse_reason varchar(32) DEFAULT NULL ,
  reported_id_manager varchar(32) DEFAULT NULL ,
  risk_des varchar(32) DEFAULT NULL ,
  risk_attribute varchar(32) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL ,
  created_at datetime DEFAULT NULL ,
  modified_by int(11) DEFAULT NULL ,
  modified_at timestamp NULL  ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_customer_social_relationship
-- ----------------------------
DROP TABLE IF EXISTS t_customer_social_relationship;
CREATE TABLE t_customer_social_relationship (
  id int(11) NOT NULL AUTO_INCREMENT,
  customer_id int(11) DEFAULT NULL ,
  relationship_name varchar(16) DEFAULT NULL ,
  relationship_age tinyint(3) DEFAULT NULL ,
  work_name varchar(64) DEFAULT NULL ,
  work_position varchar(32) DEFAULT NULL ,
  work_address varchar(64) DEFAULT NULL ,
  relationship varchar(16) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL,
  created_at datetime DEFAULT NULL,
  modified_by int(11) DEFAULT NULL,
  modified_at timestamp NULL ,
  phone varchar(32) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_customer_vedio_accessories
-- ----------------------------
DROP TABLE IF EXISTS t_customer_vedio_accessories;
CREATE TABLE t_customer_vedio_accessories (
  id int(11) NOT NULL AUTO_INCREMENT,
  customer_id int(11) DEFAULT NULL,
  server_url_path varchar(64) DEFAULT NULL,
  image_type varchar(64) DEFAULT NULL ,
  file_path varchar(255) DEFAULT NULL ,
  remark varchar(128) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL,
  created_at datetime DEFAULT NULL,
  modified_by int(11) DEFAULT NULL,
  modified_at timestamp NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_dict_address
-- ----------------------------
DROP TABLE IF EXISTS t_dict_address;
CREATE TABLE t_dict_address (
  id int(11) NOT NULL AUTO_INCREMENT,
  pid int(11) DEFAULT NULL,
  cid bigint(20) DEFAULT NULL,
  province varchar(64) DEFAULT NULL ,
  city varchar(64) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=346 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_dict_indu_condition_index
-- ----------------------------
DROP TABLE IF EXISTS t_dict_indu_condition_index;
CREATE TABLE t_dict_indu_condition_index (
  id int(11) NOT NULL AUTO_INCREMENT,
  industry varchar(64) DEFAULT NULL ,
  current_mon_index double DEFAULT NULL ,
  history_index double DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_dict_province
-- ----------------------------
DROP TABLE IF EXISTS t_dict_province;
CREATE TABLE t_dict_province (
  id int(11) NOT NULL AUTO_INCREMENT,
  province varchar(16) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_e_actual_equity
-- ----------------------------
DROP TABLE IF EXISTS t_e_actual_equity;
CREATE TABLE t_e_actual_equity (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL,
  name varchar(255) DEFAULT NULL ,
  value decimal(16,2) DEFAULT NULL ,
  remark varchar(255) DEFAULT NULL ,
  mark tinyint(1) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_e_depr_appr
-- ----------------------------
DROP TABLE IF EXISTS t_e_depr_appr;
CREATE TABLE t_e_depr_appr (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL,
  name varchar(255) DEFAULT NULL ,
  value decimal(16,2) DEFAULT NULL ,
  remark varchar(255) DEFAULT NULL ,
  mark tinyint(1) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_e_deserved_equity
-- ----------------------------
DROP TABLE IF EXISTS t_e_deserved_equity;
CREATE TABLE t_e_deserved_equity (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL,
  name varchar(255) DEFAULT NULL ,
  value decimal(16,2) DEFAULT NULL ,
  remark varchar(255) DEFAULT NULL ,
  mark tinyint(1) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_e_difference
-- ----------------------------
DROP TABLE IF EXISTS t_e_difference;
CREATE TABLE t_e_difference (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL,
  name varchar(255) DEFAULT NULL ,
  value decimal(16,2) DEFAULT NULL ,
  remark varchar(255) DEFAULT NULL ,
  mark tinyint(1) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_e_difference_ratio
-- ----------------------------
DROP TABLE IF EXISTS t_e_difference_ratio;
CREATE TABLE t_e_difference_ratio (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL,
  name varchar(255) DEFAULT NULL ,
  value decimal(16,2) DEFAULT NULL ,
  remark varchar(255) DEFAULT NULL ,
  mark tinyint(1) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_e_initial_equity
-- ----------------------------
DROP TABLE IF EXISTS t_e_initial_equity;
CREATE TABLE t_e_initial_equity (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL,
  name varchar(255) DEFAULT NULL ,
  value decimal(16,2) DEFAULT NULL ,
  remark varchar(255) DEFAULT NULL ,
  mark tinyint(1) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_e_others
-- ----------------------------
DROP TABLE IF EXISTS t_e_others;
CREATE TABLE t_e_others (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL,
  name varchar(255) DEFAULT NULL ,
  value decimal(16,2) DEFAULT NULL ,
  remark varchar(255) DEFAULT NULL ,
  mark tinyint(1) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_e_period_capital_infusion
-- ----------------------------
DROP TABLE IF EXISTS t_e_period_capital_infusion;
CREATE TABLE t_e_period_capital_infusion (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL,
  name varchar(255) DEFAULT NULL ,
  value decimal(16,2) DEFAULT NULL ,
  remark varchar(255) DEFAULT NULL ,
  mark tinyint(1) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_e_period_draw_down
-- ----------------------------
DROP TABLE IF EXISTS t_e_period_draw_down;
CREATE TABLE t_e_period_draw_down (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL,
  name varchar(255) DEFAULT NULL ,
  value decimal(16,2) DEFAULT NULL ,
  remark varchar(255) DEFAULT NULL ,
  mark tinyint(1) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_e_period_profit
-- ----------------------------
DROP TABLE IF EXISTS t_e_period_profit;
CREATE TABLE t_e_period_profit (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL,
  name varchar(255) DEFAULT NULL ,
  value decimal(16,2) DEFAULT NULL ,
  remark varchar(255) DEFAULT NULL ,
  mark tinyint(1) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_equity_cross_checking
-- ----------------------------
DROP TABLE IF EXISTS t_equity_cross_checking;
CREATE TABLE t_equity_cross_checking (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL,
  subject varchar(128) DEFAULT NULL ,
  jan decimal(12,2) DEFAULT NULL,
  feb decimal(12,2) DEFAULT NULL,
  mar decimal(12,2) DEFAULT NULL,
  apr decimal(12,2) DEFAULT NULL,
  may decimal(12,2) DEFAULT NULL,
  jun decimal(12,2) DEFAULT NULL,
  jul decimal(12,2) DEFAULT NULL,
  aug decimal(12,2) DEFAULT NULL,
  sep decimal(12,2) DEFAULT NULL,
  oct decimal(12,2) DEFAULT NULL,
  nov decimal(12,2) DEFAULT NULL,
  dece decimal(12,2) DEFAULT NULL,
  summary decimal(12,2) DEFAULT NULL ,
  comment varchar(4096) DEFAULT NULL ,
  subproject varchar(64) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=829 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_eval_advice
-- ----------------------------
DROP TABLE IF EXISTS t_eval_advice;
CREATE TABLE t_eval_advice (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL,
  product varchar(128) DEFAULT NULL ,
  loan_amount decimal(10,2) DEFAULT NULL ,
  rate double DEFAULT NULL ,
  repayment_way varchar(64) DEFAULT NULL ,
  loan_term int(11) DEFAULT NULL ,
  guarantee_method varchar(64) DEFAULT NULL ,
  comment1 varchar(1024) DEFAULT NULL ,
  comment2 varchar(1024) DEFAULT NULL ,
  comment3 varchar(1024) DEFAULT NULL ,
  comment4 varchar(1024) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL,
  created_at datetime DEFAULT NULL,
  modified_by int(11) DEFAULT NULL,
  modified_at timestamp NULL ,
  ins_repay decimal(10,2) DEFAULT NULL ,
  proportion double DEFAULT NULL ,
  remark varchar(255) DEFAULT NULL ,
  comment varchar(1024) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_expert
-- ----------------------------
DROP TABLE IF EXISTS t_expert;
CREATE TABLE t_expert (
  user_id int(11) NOT NULL ,
  level varchar(32) NOT NULL ,
  total_account decimal(10,2) NOT NULL ,
  left_account decimal(10,2) DEFAULT NULL ,
  experience_level varchar(32) DEFAULT NULL ,
  area varchar(1280) DEFAULT NULL ,
  product_type varchar(64) DEFAULT NULL ,
  PRIMARY KEY (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Table structure for t_expert_application
-- ----------------------------
DROP TABLE IF EXISTS t_expert_application;
CREATE TABLE t_expert_application (
  id int(11) NOT NULL AUTO_INCREMENT,
  expert_id int(11) DEFAULT NULL ,
  application_id int(11) DEFAULT NULL ,
  expert_evaluation_result varchar(20) DEFAULT NULL ,
  evaluation_suggestion varchar(1024) DEFAULT NULL ,
  if_boss tinyint(1) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL ,
  created_at datetime DEFAULT NULL ,
  modified_by int(11) DEFAULT NULL ,
  modified_at timestamp NULL  ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=824 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_fixed_assets
-- ----------------------------
DROP TABLE IF EXISTS t_fixed_assets;
CREATE TABLE t_fixed_assets (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL ,
  name varchar(32) DEFAULT NULL ,
  acquisition_time date DEFAULT NULL ,
  original_price decimal(8,2) DEFAULT NULL ,
  depreciate_rate double DEFAULT NULL ,
  number int(11) DEFAULT NULL ,
  total_value decimal(10,2) DEFAULT NULL ,
  depreciation_sum decimal(10,2) DEFAULT NULL ,
  depreciation_fixed_assets decimal(10,2) DEFAULT NULL ,
  sum decimal(12,2) DEFAULT NULL ,
  mark tinyint(1) DEFAULT NULL ,
  comment1 varchar(255) DEFAULT NULL ,
  comment2 varchar(255) DEFAULT NULL ,
  comment3 varchar(255) DEFAULT NULL ,
  comment4 varchar(1024) DEFAULT NULL ,
  comment5 varchar(1024) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=12331 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_goods_list
-- ----------------------------
DROP TABLE IF EXISTS t_goods_list;
CREATE TABLE t_goods_list (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) NOT NULL ,
  name varchar(255) DEFAULT NULL ,
  number int(11) DEFAULT NULL ,
  price_buy decimal(8,2) DEFAULT NULL ,
  sum_money decimal(8,2) DEFAULT NULL ,
  price_sell decimal(8,2) DEFAULT NULL ,
  subproject varchar(255) DEFAULT NULL ,
  gross double DEFAULT NULL ,
  sell_proportion double DEFAULT NULL ,
  weight double DEFAULT NULL ,
  remark varchar(255) DEFAULT NULL ,
  comment varchar(1024) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=257 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_guaranty
-- ----------------------------
DROP TABLE IF EXISTS t_guaranty;
CREATE TABLE t_guaranty (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL,
  guaranty varchar(128) DEFAULT NULL ,
  code varchar(255) DEFAULT NULL,
  license varchar(64) DEFAULT NULL ,
  address varchar(128) DEFAULT NULL ,
  proprietary varchar(128) DEFAULT NULL ,
  value decimal(12,2) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL,
  created_at datetime DEFAULT NULL,
  modified_by int(11) DEFAULT NULL,
  modified_at timestamp NULL ,
  description varchar(255) DEFAULT NULL ,
  evaluation varchar(255) DEFAULT NULL ,
  remark varchar(255) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=185 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_leader
-- ----------------------------
DROP TABLE IF EXISTS t_leader;
CREATE TABLE t_leader (
  user_id int(11) NOT NULL,
  organization_id varchar(32) DEFAULT NULL ,
  PRIMARY KEY (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_liability_list
-- ----------------------------
DROP TABLE IF EXISTS t_liability_list;
CREATE TABLE t_liability_list (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) NOT NULL ,
  name varchar(64) DEFAULT NULL ,
  object varchar(64) DEFAULT NULL ,
  money decimal(8,2) DEFAULT NULL ,
  left_money decimal(8,2) DEFAULT NULL ,
  alloted_time varchar(32) DEFAULT NULL ,
  purpose varchar(255) DEFAULT NULL ,
  overdue_date date DEFAULT NULL ,
  sendback_date date DEFAULT NULL ,
  assure_means varchar(16) DEFAULT NULL ,
  overdue_information varchar(64) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=168 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_loan
-- ----------------------------
DROP TABLE IF EXISTS t_loan;
CREATE TABLE t_loan (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL ,
  loan_date date DEFAULT NULL ,
  expiry_date date DEFAULT NULL ,
  loan_term int(11) DEFAULT NULL ,
  release_amount decimal(10,2) DEFAULT NULL ,
  release_date date DEFAULT NULL ,
  loan_amount decimal(10,2) DEFAULT NULL ,
  left_amount decimal(10,2) DEFAULT NULL ,
  business_date date DEFAULT NULL ,
  accounting_date date DEFAULT NULL ,
  created_by int(11) DEFAULT NULL,
  created_at datetime DEFAULT NULL,
  modified_by int(11) DEFAULT NULL,
  modified_at timestamp NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_loan_flow
-- ----------------------------
DROP TABLE IF EXISTS t_loan_flow;
CREATE TABLE t_loan_flow (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL ,
  numbers int(11) DEFAULT NULL ,
  repayment_amount decimal(10,2) DEFAULT NULL ,
  repayment_time datetime DEFAULT NULL ,
  charge_time datetime DEFAULT NULL ,
  if_overdue tinyint(1) DEFAULT NULL ,
  left_amount varchar(32) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL,
  creatd_at datetime DEFAULT NULL,
  modified_by int(11) DEFAULT NULL,
  modified_at timestamp NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_loan_history
-- ----------------------------
DROP TABLE IF EXISTS t_loan_history;
CREATE TABLE t_loan_history (
  id int(11) NOT NULL AUTO_INCREMENT,
  customer_id int(11) DEFAULT NULL,
  source varchar(128) DEFAULT NULL ,
  amount decimal(10,2) DEFAULT NULL ,
  loan_term int(11) DEFAULT NULL ,
  purpose_loan varchar(64) DEFAULT NULL ,
  repayment_way varchar(64) DEFAULT NULL ,
  release_date date DEFAULT NULL ,
  guarantee_method varchar(64) DEFAULT NULL ,
  left_amount decimal(10,2) DEFAULT NULL ,
  overdue varchar(128) DEFAULT NULL ,
  subject varchar(255) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_maintenance_plan_action
-- ----------------------------
DROP TABLE IF EXISTS t_maintenance_plan_action;
CREATE TABLE t_maintenance_plan_action (
  id int(11) NOT NULL AUTO_INCREMENT,
  maintenance_plan_id int(11) NOT NULL ,
  maintenance_way varchar(32) DEFAULT NULL ,
  maintenance_result varchar(32) DEFAULT NULL ,
  maintenance_start_time datetime DEFAULT NULL ,
  maintenance_end_time datetime DEFAULT NULL ,
  created_by varchar(32) DEFAULT NULL ,
  created_at datetime DEFAULT NULL,
  modified_by varchar(32) DEFAULT NULL ,
  modified_at timestamp NULL  ,
  PRIMARY KEY (id,maintenance_plan_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_manager
-- ----------------------------
DROP TABLE IF EXISTS t_manager;
CREATE TABLE t_manager (
  user_id int(11) NOT NULL ,
  level int(11) DEFAULT NULL ,
  organization_id int(11) DEFAULT NULL ,
  parent_id int(11) DEFAULT NULL ,
  reward_information varchar(32) DEFAULT NULL ,
  accountability_information varchar(32) DEFAULT NULL ,
  monthday_avg_creditline decimal(8,2) DEFAULT NULL ,
  team_monthday_avg_creditline decimal(8,2) DEFAULT NULL ,
  tube_number int(11) DEFAULT NULL ,
  activation_rate double DEFAULT NULL ,
  active_rate double DEFAULT NULL ,
  entry_time date DEFAULT NULL ,
  created_by int(11) DEFAULT NULL ,
  created_at datetime DEFAULT NULL ,
  modified_by int(11) DEFAULT NULL ,
  modified_at timestamp NULL  ,
  base_pay decimal(8,2) DEFAULT NULL ,
  cust_type_list varchar(16) DEFAULT NULL ,
  customer_type_code varchar(16) DEFAULT NULL ,
  application_qualifications tinyint(1) DEFAULT NULL ,
  apply_quato_limit varchar(16) DEFAULT NULL ,
  risk_tolerance varchar(16) DEFAULT NULL ,
  PRIMARY KEY (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS t_menu;
CREATE TABLE t_menu (
  id int(11) NOT NULL AUTO_INCREMENT ,
  name varchar(255) DEFAULT NULL ,
  level int(10) DEFAULT NULL,
  action int(11) DEFAULT NULL ,
  parent_id int(11) DEFAULT NULL ,
  picture varchar(255) DEFAULT NULL ,
  desc varchar(255) DEFAULT NULL ,
  url varchar(255) DEFAULT NULL ,
  order_number int(11) DEFAULT 0 ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_mg_assessment_score
-- ----------------------------
DROP TABLE IF EXISTS t_mg_assessment_score;
CREATE TABLE t_mg_assessment_score (
  id int(11) NOT NULL AUTO_INCREMENT,
  credit_utilization_rate double DEFAULT NULL ,
  numbererest_recovery_rate double DEFAULT NULL ,
  overdue_rate double DEFAULT NULL ,
  late_recovery_rate double DEFAULT NULL ,
  overdue_balance_rate decimal(8,2) DEFAULT NULL ,
  defective_loans_rate double DEFAULT NULL ,
  customer_potential_value varchar(255) DEFAULT NULL ,
  self_training_ability varchar(255) DEFAULT NULL ,
  team_cooperation_ability varchar(255) DEFAULT NULL ,
  customer_management_ability varchar(255) DEFAULT NULL ,
  orga_coordination_ability varchar(255) DEFAULT NULL ,
  deposit varchar(255) DEFAULT NULL ,
  banking_product varchar(255) DEFAULT NULL ,
  total_score varchar(255) DEFAULT NULL ,
  total_evaluation varchar(255) DEFAULT NULL ,
  other_evaluations varchar(255) DEFAULT NULL ,
  assessed int(11) DEFAULT NULL ,
  assessed_confirm_date date DEFAULT NULL ,
  assessor int(11) DEFAULT NULL ,
  assessment_date date DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_mg_belong_map
-- ----------------------------
DROP TABLE IF EXISTS t_mg_belong_map;
CREATE TABLE t_mg_belong_map (
  manager_id int(11) NOT NULL AUTO_INCREMENT ,
  parent_id int(11) DEFAULT NULL ,
  organization_id int(11) NOT NULL ,
  child_id int(11) DEFAULT NULL ,
  if_leaf tinyint(1) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL ,
  created_at datetime DEFAULT NULL ,
  modified_by int(11) DEFAULT NULL ,
  modified_at timestamp NULL  ,
  PRIMARY KEY (manager_id)
) ENGINE=InnoDB AUTO_INCREMENT=3271 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_mg_daily
-- ----------------------------
DROP TABLE IF EXISTS t_mg_daily;
CREATE TABLE t_mg_daily (
  id int(11) NOT NULL AUTO_INCREMENT,
  weekly_id int(11) NOT NULL ,
  what_day varchar(45) DEFAULT NULL ,
  morning_plan varchar(128) DEFAULT NULL ,
  morning_actual varchar(128) DEFAULT NULL ,
  afternoon_plan varchar(128) DEFAULT NULL ,
  afternoon_actual varchar(128) DEFAULT NULL ,
  day_summary varchar(255) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL ,
  created_at datetime DEFAULT NULL ,
  modified_by int(11) DEFAULT NULL ,
  modified_at timestamp NULL  ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_mg_downgrade_rule
-- ----------------------------
DROP TABLE IF EXISTS t_mg_downgrade_rule;
CREATE TABLE t_mg_downgrade_rule (
  id int(11) NOT NULL AUTO_INCREMENT,
  current_level int(11) NOT NULL ,
  downgrade_level int(11) DEFAULT NULL ,
  ending_performance_indicator varchar(32) DEFAULT NULL ,
  evaluation_score double DEFAULT NULL ,
  indicator_completion_rate double DEFAULT NULL ,
  team_size int(11) DEFAULT NULL ,
  quarter_performance_indicator varchar(32) DEFAULT NULL ,
  year_evaluation_score double DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_mg_ledger
-- ----------------------------
DROP TABLE IF EXISTS t_mg_ledger;
CREATE TABLE t_mg_ledger (
  id int(11) NOT NULL AUTO_INCREMENT,
  manager_id int(11) NOT NULL ,
  organization_id int(11) DEFAULT NULL ,
  tube_number int(11) DEFAULT NULL ,
  customer_maintenance_number int(11) DEFAULT NULL ,
  customer_visit_number int(11) DEFAULT NULL ,
  management_cycle varchar(64) DEFAULT NULL ,
  attendance_situation varchar(64) DEFAULT NULL ,
  daily_quality varchar(64) DEFAULT NULL ,
  weekly_quality varchar(64) DEFAULT NULL ,
  manumberen_result varchar(64) DEFAULT NULL ,
  soft_information_collection varchar(64) DEFAULT NULL ,
  money_situation varchar(64) DEFAULT NULL ,
  operating_condition varchar(64) DEFAULT NULL ,
  payment_condition varchar(64) DEFAULT NULL ,
  week_completion varchar(64) DEFAULT NULL ,
  months_complete varchar(64) DEFAULT NULL ,
  daily_loan_balance varchar(64) DEFAULT NULL ,
  leader_description varchar(64) DEFAULT NULL ,
  PRIMARY KEY (id,manager_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_mg_level_adjustment
-- ----------------------------
DROP TABLE IF EXISTS t_mg_level_adjustment;
CREATE TABLE t_mg_level_adjustment (
  id int(11) NOT NULL AUTO_INCREMENT,
  manager_id int(11) NOT NULL ,
  system_advice tinyint(1) DEFAULT NULL ,
  if_handled tinyint(1) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL ,
  created_at datetime DEFAULT NULL ,
  modified_by int(11) DEFAULT NULL ,
  modified_at timestamp NULL  ,
  original_level int(11) DEFAULT NULL ,
  adjust_after_level int(11) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_mg_maintenance
-- ----------------------------
DROP TABLE IF EXISTS t_mg_maintenance;
CREATE TABLE t_mg_maintenance (
  id int(11) NOT NULL AUTO_INCREMENT,
  level varchar(16) DEFAULT NULL ,
  weighted_number double DEFAULT NULL ,
  customer_number_award double DEFAULT NULL ,
  team_award double DEFAULT NULL ,
  allowance decimal(8,2) DEFAULT NULL ,
  insert_customer_award double DEFAULT NULL ,
  tolerate_rate varchar(16) DEFAULT NULL ,
  prepare_rate double DEFAULT NULL ,
  sleep_rate double DEFAULT NULL ,
  valid_rate double DEFAULT NULL ,
  active_rate double DEFAULT NULL ,
  activate_rate double DEFAULT NULL ,
  duty_salary decimal(8,2) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL ,
  created_at datetime DEFAULT NULL ,
  modified_by int(11) DEFAULT NULL ,
  modified_at timestamp NULL  ,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_mg_retraining
-- ----------------------------
DROP TABLE IF EXISTS t_mg_retraining;
CREATE TABLE t_mg_retraining (
  id int(11) NOT NULL AUTO_INCREMENT ,
  manager_id int(11) NOT NULL ,
  retrain_purpose varchar(32) DEFAULT NULL ,
  retrain_content varchar(255) DEFAULT NULL ,
  retrain_methods varchar(64) DEFAULT NULL ,
  retrain_place varchar(64) DEFAULT NULL ,
  retrain_time datetime DEFAULT NULL ,
  implementing_person varchar(128) DEFAULT NULL ,
  if_abandoned tinyint(1) DEFAULT NULL ,
  evaluation_score varchar(11) DEFAULT NULL ,
  test_score varchar(128) DEFAULT NULL ,
  implementation_conclusion varchar(255) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL ,
  created_at datetime DEFAULT NULL ,
  modified_by int(11) DEFAULT NULL ,
  modified_at timestamp NULL  ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_mg_risk_warning
-- ----------------------------
DROP TABLE IF EXISTS t_mg_risk_warning;
CREATE TABLE t_mg_risk_warning (
  id int(11) NOT NULL AUTO_INCREMENT,
  manager_id int(11) NOT NULL ,
  originator varchar(16) DEFAULT NULL ,
  initiate_time varchar(16) DEFAULT NULL ,
  competent_advice varchar(1024) DEFAULT NULL ,
  warning_items varchar(2048) DEFAULT NULL ,
  return_receipt varchar(255) DEFAULT NULL ,
  feedback varchar(1024) DEFAULT NULL ,
  feedback_time timestamp NULL DEFAULT NULL ,
  created_by int(11) DEFAULT NULL ,
  created_at datetime DEFAULT NULL ,
  modified_by int(11) DEFAULT NULL ,
  modified_at timestamp NULL  ,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_mg_weekly
-- ----------------------------
DROP TABLE IF EXISTS t_mg_weekly;
CREATE TABLE t_mg_weekly (
  id int(11) NOT NULL AUTO_INCREMENT,
  manager_id int(11) NOT NULL ,
  weekly_summary varchar(1024) DEFAULT NULL ,
  leader_reviews varchar(1024) DEFAULT NULL ,
  team_leader_reviews varchar(1024) DEFAULT NULL ,
  program_pref_week varchar(255) DEFAULT NULL ,
  program_real_week varchar(255) DEFAULT NULL ,
  working_num_week int(11) DEFAULT NULL ,
  comp_perf_sch varchar(255) DEFAULT NULL ,
  indicators_mcp varchar(255) DEFAULT NULL ,
  group_perf_sum varchar(1024) DEFAULT NULL ,
  resistance varchar(255) DEFAULT NULL ,
  sug_measure varchar(1024) DEFAULT NULL ,
  nw_prog_perf varchar(255) DEFAULT NULL ,
  speci_nw_pp varchar(255) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_model
-- ----------------------------
DROP TABLE IF EXISTS t_model;
CREATE TABLE t_model (
  id int(11) NOT NULL AUTO_INCREMENT ,
  name varchar(64) DEFAULT NULL ,
  remark varchar(64) DEFAULT NULL ,
  templete varchar(32) DEFAULT NULL ,
  type varchar(32) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL,
  created_at datetime DEFAULT NULL,
  modified_by int(11) DEFAULT NULL,
  modified_at timestamp NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_model_evaluation
-- ----------------------------
DROP TABLE IF EXISTS t_model_evaluation;
CREATE TABLE t_model_evaluation (
  id int(11) NOT NULL AUTO_INCREMENT,
  model_evaluation_result tinyint(4) DEFAULT NULL ,
  operating_status_evaluation_result varchar(32) DEFAULT NULL ,
  operating_status_evaluation_invalid_number int(11) DEFAULT NULL ,
  living_condition_evaluation_result varchar(32) DEFAULT NULL ,
  living_condition_evaluation_invalid_number int(11) DEFAULT NULL ,
  moral_character_evaluation_result varchar(32) DEFAULT NULL ,
  moral_character_evaluation_invalid_number int(11) DEFAULT NULL ,
  repayment_ability decimal(65,0) DEFAULT NULL ,
  repayment_ability_invalid_number int(11) DEFAULT NULL ,
  application_id int(11) DEFAULT NULL ,
  credit_line decimal(32,2) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=245 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_model_log
-- ----------------------------
DROP TABLE IF EXISTS t_model_log;
CREATE TABLE t_model_log (
  id int(11) NOT NULL AUTO_INCREMENT,
  model_id int(11) DEFAULT NULL ,
  var_id int(11) DEFAULT NULL ,
  option_name varchar(255) DEFAULT NULL ,
  var_former double DEFAULT NULL ,
  var_current double DEFAULT NULL ,
  option_former varchar(255) DEFAULT NULL ,
  option_current varchar(255) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL,
  created_at datetime DEFAULT NULL,
  modified_by int(11) DEFAULT NULL,
  modified_at timestamp NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_msg
-- ----------------------------
DROP TABLE IF EXISTS t_msg;
CREATE TABLE t_msg (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  msg varchar(255) DEFAULT NULL ,
  user_id int(11) DEFAULT NULL ,
  msg_title varchar(50) DEFAULT NULL ,
  msg_type int(11) DEFAULT NULL ,
  msg_rank int(11) DEFAULT NULL ,
  msg_limit int(11) DEFAULT NULL ,
  msg_state int(11) DEFAULT NULL ,
  create_time timestamp NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=995 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_organization
-- ----------------------------
DROP TABLE IF EXISTS t_organization;
CREATE TABLE t_organization (
  id int(11) NOT NULL AUTO_INCREMENT,
  org_id int(11) DEFAULT NULL,
  org_name varchar(64) DEFAULT NULL ,
  level tinyint(2) DEFAULT NULL ,
  parent_id int(11) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1176 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_organization_branches
-- ----------------------------
DROP TABLE IF EXISTS t_organization_branches;
CREATE TABLE t_organization_branches (
  id int(11) NOT NULL AUTO_INCREMENT,
  organization_id int(11) DEFAULT NULL ,
  branch_id int(11) DEFAULT NULL ,
  branch_name varchar(64) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_payable_advance
-- ----------------------------
DROP TABLE IF EXISTS t_payable_advance;
CREATE TABLE t_payable_advance (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL ,
  objects varchar(32) DEFAULT NULL ,
  start_date date DEFAULT NULL ,
  expiry_date date DEFAULT NULL ,
  amount decimal(8,2) DEFAULT NULL ,
  left_amount decimal(10,2) DEFAULT NULL ,
  purpose varchar(64) DEFAULT NULL ,
  contact_information varchar(32) DEFAULT NULL ,
  business_relationship varchar(16) DEFAULT NULL ,
  assure_means varchar(32) DEFAULT NULL ,
  overdue_information varchar(64) DEFAULT NULL ,
  summary decimal(10,2) DEFAULT NULL ,
  mark tinyint(1) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=12052 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_payable_advance_attached
-- ----------------------------
DROP TABLE IF EXISTS t_payable_advance_attached;
CREATE TABLE t_payable_advance_attached (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL ,
  objects varchar(32) DEFAULT NULL ,
  start_date date DEFAULT NULL ,
  expiry_date date DEFAULT NULL ,
  amount decimal(8,2) DEFAULT NULL ,
  left_amount decimal(10,2) DEFAULT NULL ,
  purpose varchar(64) DEFAULT NULL ,
  contact_information varchar(32) DEFAULT NULL ,
  business_relationship varchar(16) DEFAULT NULL ,
  assure_means varchar(32) DEFAULT NULL ,
  overdue_information varchar(64) DEFAULT NULL ,
  summary decimal(10,2) DEFAULT NULL ,
  mark tinyint(1) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=101157 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_prepaid_accounts
-- ----------------------------
DROP TABLE IF EXISTS t_prepaid_accounts;
CREATE TABLE t_prepaid_accounts (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL ,
  objects varchar(32) DEFAULT NULL ,
  start_date date DEFAULT NULL ,
  expiry_date date DEFAULT NULL ,
  amount decimal(8,2) DEFAULT NULL ,
  reason varchar(32) DEFAULT NULL ,
  contact_information varchar(32) DEFAULT NULL ,
  business_relationship varchar(16) DEFAULT NULL ,
  payment_term varchar(32) DEFAULT NULL ,
  overdue_reason varchar(64) DEFAULT NULL ,
  summary decimal(10,2) DEFAULT NULL ,
  mark tinyint(1) DEFAULT NULL ,
  expected_date date DEFAULT NULL ,
  proportion double DEFAULT NULL,
  business_history varchar(255) DEFAULT NULL ,
  turnover varchar(255) DEFAULT NULL ,
  businessing varchar(64) DEFAULT NULL ,
  business_details varchar(255) DEFAULT NULL ,
  common_month varchar(255) DEFAULT NULL ,
  business_month varchar(255) DEFAULT NULL ,
  remark varchar(255) DEFAULT NULL ,
  comment varchar(255) DEFAULT NULL ,
  count varchar(255) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_primary_business
-- ----------------------------
DROP TABLE IF EXISTS t_primary_business;
CREATE TABLE t_primary_business (
  id int(11) NOT NULL,
  application_id int(11) DEFAULT NULL,
  subject varchar(255) DEFAULT NULL ,
  subproject varchar(255) DEFAULT NULL ,
  purchase_price decimal(16,2) DEFAULT NULL ,
  selling_price decimal(16,2) DEFAULT NULL ,
  gross_profit decimal(16,2) DEFAULT NULL ,
  proportation double DEFAULT NULL ,
  weight double DEFAULT NULL ,
  remark varchar(255) DEFAULT NULL ,
  comment varchar(1024) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL,
  created_at datetime DEFAULT NULL,
  modified_by int(11) DEFAULT NULL,
  modified_at timestamp NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_privilege
-- ----------------------------
DROP TABLE IF EXISTS t_privilege;
CREATE TABLE t_privilege (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(32) NOT NULL ,
  all tinyint(1) DEFAULT NULL ,
  view tinyint(1) DEFAULT NULL ,
  create tinyint(1) DEFAULT NULL ,
  update tinyint(1) DEFAULT NULL ,
  delete tinyint(1) DEFAULT NULL ,
  path varchar(128) DEFAULT NULL ,
  description varchar(128) NOT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_product_accessories_list
-- ----------------------------
DROP TABLE IF EXISTS t_product_accessories_list;
CREATE TABLE t_product_accessories_list (
  id int(11) NOT NULL AUTO_INCREMENT ,
  product_id int(11) NOT NULL ,
  appendix_type_code varchar(32) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL ,
  created_at datetime DEFAULT NULL ,
  modified_by int(11) DEFAULT NULL ,
  modified_at timestamp NULL  ,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE86 (id) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=334 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_product_address_accessories
-- ----------------------------
DROP TABLE IF EXISTS t_product_address_accessories;
CREATE TABLE t_product_address_accessories (
  id int(10) NOT NULL AUTO_INCREMENT ,
  application_id int(10) DEFAULT NULL ,
  product_id int(11) DEFAULT NULL ,
  product_accessory_name varchar(32) DEFAULT NULL ,
  product_accessories_url varchar(32) DEFAULT NULL ,
  appendix_type_code varchar(32) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL ,
  created_at datetime DEFAULT NULL ,
  modified_by int(11) DEFAULT NULL ,
  modified_at timestamp NULL  ,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_product_back
-- ----------------------------
DROP TABLE IF EXISTS t_product_back;
CREATE TABLE t_product_back (
  id int(11) NOT NULL AUTO_INCREMENT,
  code varchar(32) NOT NULL DEFAULT '' ,
  name varchar(32) NOT NULL ,
  org_id int(11) DEFAULT NULL ,
  model int(11) DEFAULT NULL ,
  purpose_loan varchar(32) NOT NULL ,
  credit_line varchar(32) NOT NULL ,
  rate_range varchar(32) DEFAULT NULL ,
  loan_term varchar(32) NOT NULL ,
  loan_principal varchar(32) NOT NULL ,
  letter_payment_way varchar(32) DEFAULT NULL ,
  numbererest_settlement_way varchar(32) DEFAULT NULL ,
  assure_means varchar(32) DEFAULT NULL ,
  penalty_numbererest varchar(32) DEFAULT NULL ,
  product_risk_tolerance varchar(32) DEFAULT NULL ,
  status varchar(32) DEFAULT NULL ,
  product_type_code varchar(32) DEFAULT NULL ,
  await_audit varchar(32) DEFAULT NULL ,
  annual_fee decimal(8,2) DEFAULT NULL ,
  picture_url varchar(1024) DEFAULT NULL ,
  picture_name varchar(1024) DEFAULT NULL ,
  default_type tinyint(1) DEFAULT NULL ,
  independent_audit_conclusions_rules varchar(32) DEFAULT NULL ,
  censoring_the_conclusions_rules varchar(32) DEFAULT NULL ,
  money_divisional_rules varchar(32) DEFAULT NULL ,
  area_divisional_rules varchar(32) DEFAULT NULL ,
  product_type_divisional_rules varchar(32) DEFAULT NULL ,
  workingtime_dicisional_rules varchar(32) DEFAULT NULL ,
  review_mode varchar(32) DEFAULT NULL ,
  term_review varchar(32) DEFAULT NULL ,
  area_expert varchar(32) DEFAULT NULL ,
  if_area_expert tinyint(1) DEFAULT NULL ,
  advanced_expert int(11) DEFAULT NULL ,
  intermediate_expert int(11) DEFAULT NULL ,
  primary_expert int(11) DEFAULT NULL ,
  level_expert varchar(32) DEFAULT NULL ,
  industry_expert varchar(32) DEFAULT NULL ,
  working_time_expert varchar(32) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL ,
  created_at datetime DEFAULT NULL ,
  modified_by int(11) DEFAULT NULL ,
  modified_at timestamp NULL  ,
  age_min int(11) DEFAULT NULL,
  age_max int(11) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE87 (id) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=716 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_product_collection_rules
-- ----------------------------
DROP TABLE IF EXISTS t_product_collection_rules;
CREATE TABLE t_product_collection_rules (
  id int(11) NOT NULL AUTO_INCREMENT,
  product_id int(11) NOT NULL ,
  aging varchar(32) DEFAULT NULL ,
  amount decimal(8,2) DEFAULT NULL ,
  collection_time varchar(16) DEFAULT NULL ,
  collection_way varchar(16) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL ,
  created_at datetime DEFAULT NULL ,
  modified_by int(11) DEFAULT NULL ,
  modified_at timestamp NULL  ,
  overdue_day_end varchar(16) DEFAULT NULL ,
  overdue_day_start varchar(16) DEFAULT NULL ,
  operation varchar(16) DEFAULT NULL ,
  collection_type varchar(16) DEFAULT NULL ,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE88 (id) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=238 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_product_marketing_rules
-- ----------------------------
DROP TABLE IF EXISTS t_product_marketing_rules;
CREATE TABLE t_product_marketing_rules (
  id int(11) NOT NULL AUTO_INCREMENT,
  product_id int(11) NOT NULL ,
  marketing_time varchar(16) DEFAULT NULL ,
  marketing_method varchar(16) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL ,
  created_at datetime DEFAULT NULL ,
  modified_by int(11) DEFAULT NULL ,
  modified_at timestamp NULL  ,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE89 (id) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=331 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_product_organization
-- ----------------------------
DROP TABLE IF EXISTS t_product_organization;
CREATE TABLE t_product_organization (
  id int(11) NOT NULL ,
  product_id int(11) NOT NULL ,
  organization_id int(11) NOT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_product_reward_incentive
-- ----------------------------
DROP TABLE IF EXISTS t_product_reward_incentive;
CREATE TABLE t_product_reward_incentive (
  id int(11) NOT NULL AUTO_INCREMENT,
  product_id int(11) NOT NULL ,
  card_status varchar(16) DEFAULT NULL ,
  piece_number varchar(16) DEFAULT NULL ,
  reward_proportion double DEFAULT NULL ,
  nterest_income_parameter decimal(8,2) DEFAULT NULL ,
  fee_sparameter decimal(8,2) DEFAULT NULL ,
  parameters_fine decimal(8,2) DEFAULT NULL ,
  parameters_annual_fee decimal(8,2) DEFAULT NULL ,
  parameters_cost decimal(8,2) DEFAULT NULL ,
  parameters_risk_cost decimal(8,2) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL ,
  created_at datetime DEFAULT NULL ,
  modified_by int(11) DEFAULT NULL ,
  modified_at timestamp NULL  ,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_product_type
-- ----------------------------
DROP TABLE IF EXISTS t_product_type;
CREATE TABLE t_product_type (
  id int(11) NOT NULL AUTO_INCREMENT,
  type varchar(32) DEFAULT NULL ,
  test1 varchar(64) DEFAULT NULL,
  test2 varchar(64) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_profit
-- ----------------------------
DROP TABLE IF EXISTS t_profit;
CREATE TABLE t_profit (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL ,
  subject varchar(32) DEFAULT NULL ,
  jan varchar(32) DEFAULT NULL ,
  feb varchar(32) DEFAULT NULL ,
  mar varchar(32) DEFAULT NULL ,
  apr varchar(32) DEFAULT NULL ,
  may varchar(32) DEFAULT NULL ,
  jun varchar(32) DEFAULT NULL ,
  jul varchar(32) DEFAULT NULL ,
  aug varchar(32) DEFAULT NULL ,
  sep varchar(32) DEFAULT NULL ,
  oct varchar(32) DEFAULT NULL ,
  nov varchar(32) DEFAULT NULL ,
  dec varchar(45) DEFAULT NULL ,
  sum varchar(45) DEFAULT NULL ,
  month_avg varchar(32) DEFAULT NULL ,
  comment varchar(1024) DEFAULT NULL ,
  subproject varchar(255) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=582753 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_profit_attached
-- ----------------------------
DROP TABLE IF EXISTS t_profit_attached;
CREATE TABLE t_profit_attached (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL ,
  subject varchar(32) DEFAULT NULL ,
  jan decimal(16,2) DEFAULT NULL ,
  feb decimal(16,2) DEFAULT NULL ,
  mar decimal(16,2) DEFAULT NULL ,
  apr decimal(16,2) DEFAULT NULL ,
  may decimal(16,2) DEFAULT NULL ,
  jun decimal(16,2) DEFAULT NULL ,
  jul decimal(16,2) DEFAULT NULL ,
  aug decimal(16,2) DEFAULT NULL ,
  sep decimal(16,2) DEFAULT NULL ,
  oct decimal(16,2) DEFAULT NULL ,
  nov decimal(16,2) DEFAULT NULL ,
  dec decimal(16,2) DEFAULT NULL ,
  sum decimal(16,2) DEFAULT NULL ,
  month_avg decimal(16,2) DEFAULT NULL ,
  comment varchar(1024) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=607 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_profit_profile
-- ----------------------------
DROP TABLE IF EXISTS t_profit_profile;
CREATE TABLE t_profit_profile (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL ,
  subject varchar(64) DEFAULT NULL ,
  slack_time varchar(32) DEFAULT NULL ,
  normal_month varchar(32) DEFAULT NULL ,
  peak_period varchar(32) DEFAULT NULL ,
  survey_date date DEFAULT NULL ,
  sum decimal(16,2) DEFAULT NULL ,
  avg_month decimal(16,2) DEFAULT NULL ,
  comment text ,
  representative varchar(16) DEFAULT NULL ,
  subproject varchar(255) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=925 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_profit_profile_attached
-- ----------------------------
DROP TABLE IF EXISTS t_profit_profile_attached;
CREATE TABLE t_profit_profile_attached (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL ,
  subject varchar(32) DEFAULT NULL ,
  slack_time varchar(32) DEFAULT NULL ,
  normal_month varchar(32) DEFAULT NULL ,
  peak_period varchar(32) DEFAULT NULL ,
  survey_date date DEFAULT NULL ,
  sum decimal(8,2) DEFAULT NULL ,
  avg_month decimal(8,2) DEFAULT NULL ,
  comment varchar(1024) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_profit_profile_sub
-- ----------------------------
DROP TABLE IF EXISTS t_profit_profile_sub;
CREATE TABLE t_profit_profile_sub (
  id int(11) NOT NULL AUTO_INCREMENT,
  subject varchar(64) DEFAULT NULL ,
  slack_time varchar(32) DEFAULT NULL ,
  normal_month varchar(32) DEFAULT NULL ,
  peak_period varchar(32) DEFAULT NULL ,
  survey_date date DEFAULT NULL ,
  sum decimal(16,2) DEFAULT NULL ,
  avg_month decimal(16,2) DEFAULT NULL ,
  comment text ,
  representative varchar(16) DEFAULT NULL ,
  subproject varchar(255) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=933 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_profit_profile_sup
-- ----------------------------
DROP TABLE IF EXISTS t_profit_profile_sup;
CREATE TABLE t_profit_profile_sup (
  id int(11) NOT NULL AUTO_INCREMENT,
  sub_id int(11) DEFAULT NULL ,
  subject varchar(64) DEFAULT NULL ,
  slack_time varchar(32) DEFAULT NULL ,
  normal_month varchar(32) DEFAULT NULL ,
  peak_period varchar(32) DEFAULT NULL ,
  survey_date date DEFAULT NULL ,
  sum decimal(16,2) DEFAULT NULL ,
  avg_month decimal(16,2) DEFAULT NULL ,
  comment text ,
  representative varchar(16) DEFAULT NULL ,
  subproject varchar(255) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_proposed_credit_line
-- ----------------------------
DROP TABLE IF EXISTS t_proposed_credit_line;
CREATE TABLE t_proposed_credit_line (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL ,
  subject varchar(32) DEFAULT NULL ,
  jan decimal(10,2) DEFAULT NULL ,
  feb decimal(10,2) DEFAULT NULL ,
  mar decimal(10,2) DEFAULT NULL ,
  apr decimal(10,2) DEFAULT NULL ,
  may decimal(10,2) DEFAULT NULL ,
  jun decimal(10,2) DEFAULT NULL ,
  jul decimal(10,2) DEFAULT NULL ,
  aug decimal(10,2) DEFAULT NULL ,
  sep decimal(10,2) DEFAULT NULL ,
  oct decimal(10,2) DEFAULT NULL ,
  nov decimal(10,2) DEFAULT NULL ,
  dec decimal(10,2) DEFAULT NULL ,
  current decimal(10,2) DEFAULT NULL ,
  comment varchar(64) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_related_party
-- ----------------------------
DROP TABLE IF EXISTS t_related_party;
CREATE TABLE t_related_party (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL,
  name varchar(64) DEFAULT NULL ,
  type varchar(64) DEFAULT NULL ,
  proportion double DEFAULT NULL ,
  revenue decimal(16,2) DEFAULT NULL ,
  remark varchar(2014) DEFAULT NULL ,
  commemt varchar(1024) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL,
  created_at datetime DEFAULT NULL,
  modified_by int(11) DEFAULT NULL,
  modified_at timestamp NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS t_role;
CREATE TABLE t_role (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(32) NOT NULL,
  cname varchar(32) DEFAULT NULL,
  created_by int(11) DEFAULT NULL,
  created_at datetime DEFAULT NULL,
  modified_by int(11) DEFAULT NULL,
  modified_at timestamp NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_role_menu
-- ----------------------------
DROP TABLE IF EXISTS t_role_menu;
CREATE TABLE t_role_menu (
  role_id int(11) DEFAULT NULL ,
  menu_id int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_role_privilege
-- ----------------------------
DROP TABLE IF EXISTS t_role_privilege;
CREATE TABLE t_role_privilege (
  rid int(11) NOT NULL,
  pid int(11) NOT NULL,
  PRIMARY KEY (rid,pid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_rule
-- ----------------------------
DROP TABLE IF EXISTS t_rule;
CREATE TABLE t_rule (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(255) DEFAULT NULL ,
  content text ,
  version varchar(255) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL,
  created_at datetime DEFAULT NULL,
  modified_by int(11) DEFAULT NULL,
  modified_at timestamp NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_shareholder
-- ----------------------------
DROP TABLE IF EXISTS t_shareholder;
CREATE TABLE t_shareholder (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL,
  name varchar(128) DEFAULT NULL ,
  id_number varchar(18) DEFAULT NULL ,
  shares_proportion double DEFAULT NULL ,
  tel varchar(20) DEFAULT NULL ,
  home_address varchar(128) DEFAULT NULL ,
  remark varchar(255) DEFAULT NULL ,
  comment varchar(1024) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_supplier
-- ----------------------------
DROP TABLE IF EXISTS t_supplier;
CREATE TABLE t_supplier (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL,
  name varchar(64) DEFAULT NULL ,
  buy_proportion double DEFAULT NULL ,
  repayment_type varchar(64) DEFAULT NULL ,
  main_customers varchar(255) DEFAULT NULL ,
  sell_proportion double DEFAULT NULL ,
  payment_type varchar(64) DEFAULT NULL ,
  remark varchar(255) DEFAULT NULL ,
  comment varchar(255) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL,
  created_at datetime DEFAULT NULL,
  modified_by int(11) DEFAULT NULL,
  modified_at timestamp NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_turnover_cross_checking
-- ----------------------------
DROP TABLE IF EXISTS t_turnover_cross_checking;
CREATE TABLE t_turnover_cross_checking (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL,
  name varchar(255) DEFAULT NULL ,
  value decimal(16,2) DEFAULT NULL ,
  remark varchar(255) DEFAULT NULL ,
  mark tinyint(1) DEFAULT NULL ,
  analysis varchar(2048) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_up_application_var
-- ----------------------------
DROP TABLE IF EXISTS t_up_application_var;
CREATE TABLE t_up_application_var (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  application_id bigint(20) DEFAULT NULL ,
  var_code varchar(32) DEFAULT NULL ,
  value varchar(1024) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1504 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_up_group
-- ----------------------------
DROP TABLE IF EXISTS t_up_group;
CREATE TABLE t_up_group (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(64) DEFAULT NULL,
  parent_id bigint(20) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_up_var
-- ----------------------------
DROP TABLE IF EXISTS t_up_var;
CREATE TABLE t_up_var (
  code varchar(64) NOT NULL ,
  v_name varchar(64) DEFAULT NULL ,
  v_cname varchar(64) DEFAULT NULL ,
  data_type varchar(32) DEFAULT NULL ,
  explain varchar(1024) DEFAULT NULL ,
  gid int(11) DEFAULT NULL ,
  PRIMARY KEY (code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS t_user;
CREATE TABLE t_user (
  id int(11) NOT NULL AUTO_INCREMENT ,
  name varchar(32) NOT NULL ,
  cname varchar(32) NOT NULL ,
  password varchar(32) NOT NULL ,
  home_address varchar(255) DEFAULT NULL ,
  tel varchar(18) NOT NULL ,
  sex tinyint(1) NOT NULL ,
  active tinyint(1) DEFAULT '1' ,
  email varchar(128) DEFAULT NULL ,
  work_address varchar(255) DEFAULT NULL ,
  certificate_type varchar(32) DEFAULT NULL ,
  id_number varchar(32) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL ,
  created_at datetime DEFAULT NULL ,
  modified_by int(11) DEFAULT NULL ,
  modified_at timestamp NULL  ,
  remarks text ,
  last_login datetime DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1399 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user_customer
-- ----------------------------
DROP TABLE IF EXISTS t_user_customer;
CREATE TABLE t_user_customer (
  user_id int(11) DEFAULT NULL ,
  customer_id int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS t_user_role;
CREATE TABLE t_user_role (
  uid int(11) NOT NULL,
  rid int(11) NOT NULL,
  PRIMARY KEY (uid,rid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user_token
-- ----------------------------
DROP TABLE IF EXISTS t_user_token;
CREATE TABLE t_user_token (
  user_id int(11) NOT NULL ,
  token varchar(255) NOT NULL DEFAULT '' ,
  create_time timestamp NULL DEFAULT NULL ,
  expire_time timestamp NULL DEFAULT NULL ,
  PRIMARY KEY (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_using_plan
-- ----------------------------
DROP TABLE IF EXISTS t_using_plan;
CREATE TABLE t_using_plan (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL,
  subject varchar(64) DEFAULT NULL ,
  plan_amount decimal(10,2) DEFAULT NULL ,
  source varchar(64) DEFAULT NULL ,
  source_amount decimal(10,2) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL,
  created_at datetime DEFAULT NULL,
  modified_by int(11) DEFAULT NULL,
  modified_at timestamp NULL DEFAULT NULL,
  remark varchar(255) DEFAULT NULL ,
  comment varchar(255) DEFAULT NULL ,
  mark tinyint(4) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_value
-- ----------------------------
DROP TABLE IF EXISTS t_value;
CREATE TABLE t_value (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(64) DEFAULT NULL,
  value varchar(128) DEFAULT NULL,
  model int(11) DEFAULT NULL,
  weight double DEFAULT NULL,
  test1 varchar(64) DEFAULT NULL,
  test2 varchar(64) DEFAULT NULL,
  test3 varchar(64) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=337 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_var
-- ----------------------------
DROP TABLE IF EXISTS t_var;
CREATE TABLE t_var (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(64) NOT NULL ,
  gid int(11) NOT NULL ,
  type varchar(16) DEFAULT 'string' ,
  input_type varchar(16) DEFAULT 'select' ,
  has_options tinyint(1) NOT NULL DEFAULT '0',
  weight double NOT NULL DEFAULT '0' ,
  availible tinyint(1) NOT NULL DEFAULT '1' ,
  position int(3) DEFAULT NULL ,
  belong_table int(3) DEFAULT NULL ,
  description varchar(255) DEFAULT NULL,
  model int(11) DEFAULT NULL ,
  PRIMARY KEY (id),
) ENGINE=InnoDB AUTO_INCREMENT=16012 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_var_group
-- ----------------------------
DROP TABLE IF EXISTS t_var_group;
CREATE TABLE t_var_group (
  id int(10) NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL ,
  parent_id int(11) DEFAULT NULL,
  desc varchar(4096) DEFAULT NULL ,
  weight double DEFAULT '0' ,
  belong_table int(11) DEFAULT NULL ,
  model_id int(11) DEFAULT NULL ,
  page varchar(128) DEFAULT NULL ,
  if_second_menu int(255) DEFAULT '0',
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=2129 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_var_option
-- ----------------------------
DROP TABLE IF EXISTS t_var_option;
CREATE TABLE t_var_option (
  id int(10) NOT NULL AUTO_INCREMENT,
  vid int(11) NOT NULL ,
  name varchar(64) NOT NULL DEFAULT '' ,
  value varchar(4096) DEFAULT NULL ,
  tag tinyint(1) DEFAULT '1',
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=3104 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_workflow
-- ----------------------------
DROP TABLE IF EXISTS t_workflow;
CREATE TABLE t_workflow (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(255) DEFAULT NULL ,
  content text ,
  version varchar(255) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL,
  created_at datetime DEFAULT NULL,
  modified_by int(11) DEFAULT NULL,
  modified_at timestamp NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS t_customer_credit_information;
CREATE TABLE t_customer_credit_information (
  id int(11) NOT NULL AUTO_INCREMENT,
  customer_id int(11) DEFAULT NULL,
  net_value decimal(8,2) DEFAULT NULL ,
  model_type int(2) DEFAULT NULL ,
  house_value decimal(10,2) DEFAULT NULL ,
  car_value decimal(10,2) DEFAULT NULL ,
  other_value decimal(10,2) DEFAULT NULL ,
  debit_remaining_value decimal(10,2) DEFAULT NULL ,
  total_used_amount_max decimal(10,2) DEFAULT NULL ,
  total_credit_amount decimal(10,2) DEFAULT NULL ,
  other_debit_value decimal(10,2) DEFAULT NULL ,
  if_daily_flow_over_10000 int(1) DEFAULT NULL ,
  if_have_record int(1) DEFAULT NULL ,
  if_credit_below_70per int(1) DEFAULT NULL ,
  if_livelihood int(1) DEFAULT NULL ,
  if_our_business int(1) DEFAULT NULL ,
  if_have_loans int(1) DEFAULT NULL ,
  if_car_value_over_5 int(1) DEFAULT NULL ,
  if_self_business_life_over_1 int(1) DEFAULT NULL ,
  credit_limit decimal(10,2) DEFAULT NULL ,
  average_daily_flow decimal(10,2) DEFAULT NULL ,
  capital_value decimal(10,2) DEFAULT NULL ,
  family_line_credit decimal(10,2) DEFAULT NULL ,
  customer_type int(2) DEFAULT NULL ,
  guarantor_type int(2) DEFAULT NULL ,
  applicant_assets decimal(10,2) DEFAULT NULL ,
  guarantor_liablity decimal(10,2) DEFAULT NULL ,
  applicant_liablity decimal(10,2) DEFAULT NULL ,
  guarantor_house_value decimal(10,2) DEFAULT NULL ,
  guarantor_car_value decimal(10,2) DEFAULT NULL ,
  guarantor_other_value decimal(10,2) DEFAULT NULL ,
  guarantor_credit_loan decimal(10,2) DEFAULT NULL ,
  guarantor_credit_used_max decimal(10,2) DEFAULT NULL ,
  guarantor_credit_total_limit decimal(10,2) DEFAULT NULL ,
  guarantor_external_amount decimal(10,2) DEFAULT NULL ,
  applicant_credit_loan_sum decimal(10,2) DEFAULT NULL ,
  applicant_credit_used_max decimal(10,2) DEFAULT NULL ,
  applicant_credit_total_quota decimal(10,2) DEFAULT NULL ,
  applicant_external_amount decimal(10,2) DEFAULT NULL ,
  guarantor_amount int(2) DEFAULT NULL ,
  if_high_quality_industry int(1) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL,
  created_at date DEFAULT NULL,
  modified_by int(11) DEFAULT NULL,
  modified_at timestamp NULL ,
  tax_info varchar(50) DEFAULT NULL ,
  insuarance_info varchar(50) DEFAULT NULL ,
  business_credit varchar(50) DEFAULT NULL ,
  civilIs_sure varchar(50) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_customer_household_members_information
-- ----------------------------
DROP TABLE IF EXISTS t_customer_household_members_information;
CREATE TABLE t_customer_household_members_information (
  id int(11) NOT NULL AUTO_INCREMENT,
  customer_id int(11) NOT NULL ,
  member_name varchar(16)  DEFAULT NULL ,
  member_age int(3) DEFAULT NULL ,
  relationship varchar(16)  DEFAULT NULL ,
  work_name varchar(64)  DEFAULT NULL ,
  political_status int(2) DEFAULT NULL ,
  income_month decimal(8,2) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL,
  created_at date DEFAULT NULL,
  modified_by int(11) DEFAULT NULL,
  modified_at timestamp NULL ,
  id_number varchar(18)  DEFAULT NULL ,
  tel varchar(20)  DEFAULT '' ,
  home_address varchar(128)  DEFAULT NULL ,
  income_year decimal(10,2) DEFAULT NULL ,
  main_assets varchar(64)  DEFAULT NULL ,
  company_name varchar(128)  DEFAULT NULL ,
  position varchar(64)  DEFAULT NULL ,
  work_address varchar(128)  DEFAULT NULL ,
  remark varchar(255)  DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=225 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_cost_gross_profit_checking
-- ----------------------------
DROP TABLE IF EXISTS t_cost_gross_profit_checking;
CREATE TABLE t_cost_gross_profit_checking (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL ,
  product_type varchar(32) DEFAULT NULL ,
  purchase_price decimal(10,2) DEFAULT NULL ,
  selling_price decimal(10,2) DEFAULT NULL ,
  gross_profit_tate double DEFAULT NULL,
  sale_percentage double DEFAULT NULL,
  weighted_margin double DEFAULT NULL ,
  weighted_checking double DEFAULT NULL ,
  dictation double DEFAULT NULL ,
  weighted_avg double DEFAULT NULL ,
  summary double DEFAULT NULL ,
  mark int(1) DEFAULT NULL ,
  analysis varchar(1500) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_application
-- ----------------------------
DROP TABLE IF EXISTS t_application;
CREATE TABLE t_application (
  id int(11) NOT NULL,
  code varchar(32) DEFAULT NULL,
  customer_id int(11) DEFAULT NULL,
  product_id int(11) DEFAULT NULL,
  manager_id int(11) DEFAULT NULL,
  apply_quota decimal(12,2) DEFAULT NULL,
  final_approval varchar(16) DEFAULT NULL,
  actual_quota decimal(8,2) DEFAULT NULL ,
  temporary_quota decimal(8,2) DEFAULT NULL,
  cash_advance_proportion double DEFAULT NULL,
  card_status varchar(16)  DEFAULT NULL,
  account_status varchar(16)  DEFAULT NULL,
  billing_date varchar(16)  DEFAULT NULL ,
  repayment_agreement decimal(8,2) DEFAULT NULL,
  automatic_repayment_agreement int(1) DEFAULT NULL,
  customer_risk_rating varchar(16)  DEFAULT NULL,
  aging varchar(16)  DEFAULT NULL,
  debit_way varchar(16)  DEFAULT NULL,
  repayment_card_number varchar(19)  DEFAULT NULL,
  status varchar(32)  DEFAULT NULL,
  upload_status varchar(16)  DEFAULT NULL,
  completion_time TIMESTAMP DEFAULT NULL ,
  card_number varchar(19)  DEFAULT NULL,
  is_auto_pay int(1) DEFAULT NULL,
  serial_number varchar(32)  DEFAULT NULL,
  application_type varchar(32)  DEFAULT NULL,
  spare_type varchar(32)  DEFAULT NULL,
  customer_type varchar(32)  DEFAULT NULL,
  loan_term varchar(16)  NOT NULL,
  billing_method varchar(64)  DEFAULT NULL,
  paper_billing_shipping_address varchar(64) DEFAULT NULL,
  consumption_use_password int(1) DEFAULT NULL,
  sys_opening_trading int(1) DEFAULT NULL,
  created_by int(11) DEFAULT NULL,
  created_at TIMESTAMP DEFAULT NULL,
  modified_by int(11) DEFAULT NULL ,
  modified_at timestamp NULL,
  model int(11) DEFAULT NULL,
  proposed_date TIMESTAMP DEFAULT NULL,
  customer_age int(11) DEFAULT NULL,
  repayment_way varchar(64)  DEFAULT NULL,
  guarantee_method varchar(64)  DEFAULT NULL,
  rate double DEFAULT NULL,
  apply_date TIMESTAMP DEFAULT NULL,
  purpose_loan varchar(255)  DEFAULT NULL,
  remark varchar(255)  DEFAULT NULL,
  file_path varchar(255)  DEFAULT NULL,
  collar_card_mode varchar(32) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=2621 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS t_product;
CREATE TABLE t_product (
  id int(11) NOT NULL AUTO_INCREMENT,
  code varchar(32) NOT NULL,
  name varchar(32) NOT NULL ,
  org_id int(11) DEFAULT NULL ,
  model int(11) DEFAULT NULL ,
  purpose_loan varchar(32) DEFAULT NULL ,
  credit_line varchar(32) DEFAULT NULL ,
  rate_range varchar(32)  DEFAULT NULL ,
  loan_term varchar(32) DEFAULT NULL ,
  loan_principal varchar(32) DEFAULT NULL ,
  letter_payment_way varchar(32) DEFAULT NULL ,
  numbererest_settlement_way varchar(32) DEFAULT NULL ,
  assure_means varchar(32) DEFAULT NULL ,
  penalty_numbererest varchar(32) DEFAULT NULL ,
  product_risk_tolerance varchar(32) DEFAULT NULL ,
  status varchar(32) DEFAULT NULL ,
  product_type_code varchar(32) DEFAULT NULL ,
  await_audit varchar(32) DEFAULT NULL ,
  annual_fee decimal(8,2) DEFAULT NULL ,
  picture_url varchar(1024) DEFAULT NULL ,
  picture_name varchar(1024) DEFAULT NULL ,
  default_type int(1) DEFAULT NULL ,
  independent_audit_conclusions_rules varchar(32) DEFAULT NULL ,
  censoring_the_conclusions_rules varchar(32) DEFAULT NULL ,
  money_divisional_rules varchar(32) DEFAULT NULL ,
  area_divisional_rules varchar(32) DEFAULT NULL ,
  product_type_divisional_rules varchar(32) DEFAULT NULL ,
  workingtime_dicisional_rules varchar(32) DEFAULT NULL ,
  review_mode varchar(32) DEFAULT NULL ,
  term_review varchar(32) DEFAULT NULL ,
  area_expert varchar(32) DEFAULT NULL ,
  if_area_expert int(1) DEFAULT NULL ,
  advanced_expert int(11) DEFAULT NULL ,
  intermediate_expert int(11) DEFAULT NULL ,
  primary_expert int(11) DEFAULT NULL ,
  level_expert varchar(32) DEFAULT NULL ,
  industry_expert varchar(32) DEFAULT NULL ,
  working_time_expert varchar(32) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL ,
  created_at timestamp DEFAULT NULL ,
  modified_by int(11) DEFAULT NULL ,
  modified_at timestamp NULL  ,
  age_min int(11) DEFAULT NULL,
  age_max int(11) DEFAULT NULL,
  start_enable_time timestamp DEFAULT NULL ,
  end_disable_time timestamp DEFAULT NULL ,
  annual_interest_rate double DEFAULT NULL ,
  counter_fee double DEFAULT NULL ,
  consulting_fee double DEFAULT NULL ,
  insurance_fee double DEFAULT NULL ,
  stamp_duty_rate double DEFAULT NULL ,
  grace_period int(11) DEFAULT NULL ,
  credit_line_min decimal(10,2) DEFAULT NULL ,
  credit_line_max decimal(10,2) DEFAULT NULL ,
  loan_term_min int(4) DEFAULT NULL ,
  loan_term_max int(4) DEFAULT NULL ,
  baddebtdelay_day int(10),
  rules_id int(11) DEFAULT NULL ,
  rate_range_min double  DEFAULT NULL ,
  rate_range_max double DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=900 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_role_menu
-- ----------------------------
DROP TABLE IF EXISTS t_role_menu;
CREATE TABLE t_role_menu (
  role_id int(11) DEFAULT NULL ,
  menu_id int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_stock
-- ----------------------------
DROP TABLE IF EXISTS t_stock;
CREATE TABLE t_stock (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL,
  type varchar(255)   DEFAULT NULL ,
  name varchar(255)   DEFAULT NULL ,
  unit varchar(255)  DEFAULT NULL ,
  amount int(11) DEFAULT NULL ,
  cost decimal(10,2) DEFAULT NULL ,
  total_value decimal(10,2) DEFAULT NULL ,
  remark varchar(255) DEFAULT NULL,
  sum decimal(10,2) DEFAULT NULL ,
  comment varchar(255)  DEFAULT NULL ,
  created_by int(11) DEFAULT NULL,
  created_at datetime DEFAULT NULL,
  modified_by int(11) DEFAULT NULL,
  modified_at timestamp NULL DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
-- ----------------------------
-- Table structure for t_guarantee_others
-- ----------------------------
DROP TABLE IF EXISTS t_guarantee_others;
CREATE TABLE t_guarantee_others (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL,
  relationship varchar(64) DEFAULT NULL ,
  organization varchar(255) DEFAULT NULL,
  guaranteed_amount decimal(16,2) DEFAULT NULL ,
  guarantee_start date DEFAULT NULL ,
  guarantee_end date DEFAULT NULL,
  guaranty_style varchar(64) DEFAULT NULL ,
  amount_left decimal(16,2) DEFAULT NULL ,
  remark varchar(1024) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL,
  created_at datetime DEFAULT NULL,
  modified_by int(11) DEFAULT NULL,
  modified_at timestamp NULL DEFAULT NULL,
  name varchar(64) DEFAULT NULL ,
  alloted_time varchar(32) DEFAULT NULL ,
  purpose varchar(255) DEFAULT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 ;
-- ----------------------------
-- Table structure for t_shareholders
-- ----------------------------
CREATE TABLE t_shareholders (
  id int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11) DEFAULT NULL,
  name varchar(64) DEFAULT NULL ,
  id_number varchar(255) DEFAULT NULL ,
  proportion double DEFAULT NULL,
  tel varchar(18) DEFAULT NULL,
  business_address varchar(255) DEFAULT NULL ,
  home_address varchar(255) DEFAULT NULL ,
  living_type varchar(255) DEFAULT NULL ,
  remark varchar(1024) DEFAULT NULL ,
  created_by int(11) DEFAULT NULL,
  created_at datetime DEFAULT NULL,
  modified_by int(11) DEFAULT NULL,
  modified_at timestamp NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 ;








