/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.submarine.commons.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubmarineConfVars {
  private static final Logger LOG = LoggerFactory.getLogger(SubmarineConfVars.class);
  public enum ConfVars {
    
    FLOAT_TEST("float.test", VarType.FLOAT),
    SUBMARINE_CONF_DIR("submarine.conf.dir", VarType.STRING),
    SUBMARINE_LOCALIZATION_MAX_ALLOWED_FILE_SIZE_MB(
        "submarine.localization.max-allowed-file-size-mb", VarType.LONG),
    SUBMARINE_SERVER_ADDR("submarine.server.addr", VarType.STRING),
    SUBMARINE_SERVER_PORT("submarine.server.port", VarType.INT),
    SUBMARINE_SERVER_SSL("submarine.server.ssl", VarType.BOOLEAN),
    SUBMARINE_SERVER_SSL_PORT("submarine.server.ssl.port", VarType.INT),
    SUBMARINE_SERVER_JETTY_THREAD_POOL_MAX("submarine.server.jetty.thread.pool.max", VarType.INT),
    SUBMARINE_SERVER_JETTY_THREAD_POOL_MIN("submarine.server.jetty.thread.pool.min", VarType.INT),
    SUBMARINE_SERVER_JETTY_THREAD_POOL_TIMEOUT("submarine.server.jetty.thread.pool.timeout", VarType.INT),
    SUBMARINE_SERVER_JETTY_REQUEST_HEADER_SIZE("submarine.server.jetty.request.header.size", VarType.INT),
    SUBMARINE_SERVER_SSL_CLIENT_AUTH("submarine.server.ssl.client.auth", VarType.BOOLEAN),
    SUBMARINE_SERVER_SSL_KEYSTORE_PATH("submarine.server.ssl.keystore.path", VarType.STRING),
    SUBMARINE_SERVER_SSL_KEYSTORE_TYPE("submarine.server.ssl.keystore.type", VarType.STRING),
    SUBMARINE_SERVER_SSL_KEYSTORE_PASSWORD("submarine.server.ssl.keystore.password", VarType.STRING),
    SUBMARINE_SERVER_SSL_KEY_MANAGER_PASSWORD("submarine.server.ssl.key.manager.password", VarType.STRING),
    SUBMARINE_SERVER_SSL_TRUSTSTORE_PATH("submarine.server.ssl.truststore.path", VarType.STRING),
    SUBMARINE_SERVER_SSL_TRUSTSTORE_TYPE("submarine.server.ssl.truststore.type", VarType.STRING),
    SUBMARINE_SERVER_SSL_TRUSTSTORE_PASSWORD("submarine.server.ssl.truststore.password", VarType.STRING),
    SUBMARINE_CLUSTER_ADDR("submarine.cluster.addr", VarType.STRING),
    SUBMARINE_SERVER_RPC_ENABLED(
        "submarine.server.rpc.enabled", VarType.BOOLEAN),
    SUBMARINE_SERVER_RPC_PORT(
        "submarine.server.rpc.port", VarType.INT),
    CLUSTER_HEARTBEAT_INTERVAL("cluster.heartbeat.interval", VarType.INT),
    CLUSTER_HEARTBEAT_TIMEOUT("cluster.heartbeat.timeout", VarType.INT),

    JDBC_DRIVERCLASSNAME("jdbc.driverClassName", VarType.STRING),
    JDBC_URL("jdbc.url", VarType.STRING),
    JDBC_USERNAME("jdbc.username", VarType.STRING),
    JDBC_PASSWORD("jdbc.password", VarType.STRING),
    METASTORE_JDBC_URL("metastore.jdbc.url", VarType.STRING),
    METASTORE_JDBC_USERNAME("metastore.jdbc.username", VarType.STRING),
    METASTORE_JDBC_PASSWORD("metastore.jdbc.password", VarType.STRING),

    SUBMARINE_NOTEBOOK_DEFAULT_OVERWRITE_JSON("submarine.notebook.default.overwrite_json", VarType.STRING),

    WORKBENCH_WEBSOCKET_MAX_TEXT_MESSAGE_SIZE(
        "workbench.websocket.max.text.message.size", VarType.STRING),
    WORKBENCH_WEB_WAR("workbench.web.war", VarType.STRING),
    SUBMARINE_RUNTIME_CLASS("submarine.runtime.class",
        "org.apache.submarine.server.submitter.yarn.YarnRuntimeFactory"),
    SUBMARINE_SUBMITTER("submarine.submitter", VarType.STRING),
    SUBMARINE_SERVER_SERVICE_NAME("submarine.server.service.name", VarType.STRING),
    ENVIRONMENT_CONDA_MIN_VERSION("environment.conda.min.version", VarType.STRING),
    ENVIRONMENT_CONDA_MAX_VERSION("environment.conda.max.version", VarType.STRING);
    
    /*
    FLOAT_TEST("float.test", -123.456f),
    SUBMARINE_CONF_DIR("submarine.conf.dir", "conf"),
    SUBMARINE_LOCALIZATION_MAX_ALLOWED_FILE_SIZE_MB(
        "submarine.localization.max-allowed-file-size-mb",
        Long.parseLong(System.getenv("SUBMARINE_LOCALIZATION_MAX_ALLOWED_FILE_SIZE_MB"))),
    SUBMARINE_SERVER_ADDR("submarine.server.addr", System.getenv("SUBMARINE_SERVER_ADDR")),
    SUBMARINE_SERVER_PORT("submarine.server.port", Integer.valueOf(System.getenv("SUBMARINE_SERVER_PORT"))),
    SUBMARINE_SERVER_SSL("submarine.server.ssl", Boolean.parseBoolean(System.getenv("SUBMARINE_SERVER_SSL"))),
    SUBMARINE_SERVER_SSL_PORT("submarine.server.ssl.port",
        Integer.valueOf(System.getenv("SUBMARINE_SERVER_SSL_PORT"))),
    SUBMARINE_SERVER_JETTY_THREAD_POOL_MAX("submarine.server.jetty.thread.pool.max",
        Integer.valueOf(System.getenv("SUBMARINE_SERVER_JETTY_THREAD_POOL_MAX"))),
    SUBMARINE_SERVER_JETTY_THREAD_POOL_MIN("submarine.server.jetty.thread.pool.min",
        Integer.valueOf(System.getenv("SUBMARINE_SERVER_JETTY_THREAD_POOL_MIN"))),
    SUBMARINE_SERVER_JETTY_THREAD_POOL_TIMEOUT("submarine.server.jetty.thread.pool.timeout",
        Integer.valueOf(System.getenv("SUBMARINE_SERVER_JETTY_THREAD_POOL_TIMEOUT"))),
    SUBMARINE_SERVER_JETTY_REQUEST_HEADER_SIZE("submarine.server.jetty.request.header.size",
        Integer.valueOf(System.getenv("SUBMARINE_SERVER_JETTY_REQUEST_HEADER_SIZE"))),
    SUBMARINE_SERVER_SSL_CLIENT_AUTH("submarine.server.ssl.client.auth",
        Boolean.parseBoolean(System.getenv("SUBMARINE_SERVER_SSL_CLIENT_AUTH"))),
    SUBMARINE_SERVER_SSL_KEYSTORE_PATH("submarine.server.ssl.keystore.path",
        System.getenv("SUBMARINE_SERVER_SSL_KEYSTORE_PATH")),
    SUBMARINE_SERVER_SSL_KEYSTORE_TYPE("submarine.server.ssl.keystore.type",
        System.getenv("SUBMARINE_SERVER_SSL_KEYSTORE_TYPE")),
    SUBMARINE_SERVER_SSL_KEYSTORE_PASSWORD("submarine.server.ssl.keystore.password",
        System.getenv("SUBMARINE_SERVER_SSL_KEYSTORE_PASSWORD")),
    SUBMARINE_SERVER_SSL_KEY_MANAGER_PASSWORD("submarine.server.ssl.key.manager.password",
        System.getenv("SUBMARINE_SERVER_SSL_KEY_MANAGER_PASSWORD") == "" ? null :
        System.getenv("SUBMARINE_SERVER_SSL_KEY_MANAGER_PASSWORD")),
    SUBMARINE_SERVER_SSL_TRUSTSTORE_PATH("submarine.server.ssl.truststore.path",
        System.getenv("SUBMARINE_SERVER_SSL_TRUSTSTORE_PATH") == "" ? null :
        System.getenv("SUBMARINE_SERVER_SSL_TRUSTSTORE_PATH")),
    SUBMARINE_SERVER_SSL_TRUSTSTORE_TYPE("submarine.server.ssl.truststore.type",
        System.getenv("SUBMARINE_SERVER_SSL_TRUSTST_TYPE") == "" ? null :
        System.getenv("SUBMARINE_SERVER_SSL_TRUSTST_TYPE")),
    SUBMARINE_SERVER_SSL_TRUSTSTORE_PASSWORD("submarine.server.ssl.truststore.password",
        System.getenv("SUBMARINE_SERVER_SSL_TRUSTSTORE_PASSWORD") == "" ? null :
        System.getenv("SUBMARINE_SERVER_SSL_TRUSTSTORE_PASSWORD")),
    SUBMARINE_CLUSTER_ADDR("submarine.cluster.addr",
        System.getenv("SUBMARINE_CLUSTER_ADDR")),
    SUBMARINE_SERVER_RPC_ENABLED(
        "submarine.server.rpc.enabled",
        Boolean.parseBoolean(System.getenv("SUBMARINE_SERVER_RPC_ENABLED"))),
    SUBMARINE_SERVER_RPC_PORT(
        "submarine.server.rpc.port", 8980),
    CLUSTER_HEARTBEAT_INTERVAL("cluster.heartbeat.interval",
        Integer.valueOf(System.getenv("CLUSTER_HEARTBEAT_INTERVAL"))),
    CLUSTER_HEARTBEAT_TIMEOUT("cluster.heartbeat.timeout",
        Integer.valueOf(System.getenv("CLUSTER_HEARTBEAT_TIMEOUT"))),

    JDBC_DRIVERCLASSNAME("jdbc.driverClassName", System.getenv("JDBC_DRIVERCLASSNAME")),
    JDBC_URL("jdbc.url", System.getenv("JDBC_URL")),
    JDBC_USERNAME("jdbc.username", System.getenv("JDBC_USERNAME")),
    JDBC_PASSWORD("jdbc.password", System.getenv("JDBC_PASSWORD")),
    METASTORE_JDBC_URL("metastore.jdbc.url", System.getenv("METASTORE_JDBC_URL")),
    METASTORE_JDBC_USERNAME("metastore.jdbc.username", System.getenv("METASTORE_JDBC_USERNAME")),
    METASTORE_JDBC_PASSWORD("metastore.jdbc.password", System.getenv("METASTORE_JDBC_PASSWORD")),

    SUBMARINE_NOTEBOOK_DEFAULT_OVERWRITE_JSON("submarine.notebook.default.overwrite_json",
        System.getenv("SUBMARINE_NOTEBOOK_DEFAULT_OVERWRITE_JSON")),

    WORKBENCH_WEBSOCKET_MAX_TEXT_MESSAGE_SIZE(
        "workbench.websocket.max.text.message.size", "1024000"),
    WORKBENCH_WEB_WAR("workbench.web.war", "submarine-workbench/workbench-web/dist"),
    SUBMARINE_RUNTIME_CLASS("submarine.runtime.class",
        "org.apache.submarine.server.submitter.yarn.YarnRuntimeFactory"),
    SUBMARINE_SUBMITTER("submarine.submitter", "k8s"),
    SUBMARINE_SERVER_SERVICE_NAME("submarine.server.service.name", "submarine-server"),
    ENVIRONMENT_CONDA_MIN_VERSION("environment.conda.min.version", "4.0.1"),
    ENVIRONMENT_CONDA_MAX_VERSION("environment.conda.max.version", "4.11.10");
    */
    private String varName;
    @SuppressWarnings("rawtypes")
    private Class varClass;
    private String stringValue;
    private VarType type;
    private int intValue;
    private float floatValue;
    private boolean booleanValue;
    private long longValue;

    
    ConfVars(String varName, VarType type) {
      switch(type) {
        case STRING:
          this.varName = varName;
          this.varClass = String.class;
          if (varName == "submarine.server.ssl.key.manager.password" ||
              varName == "submarine.server.ssl.truststore.path" || 
              varName == "submarine.server.ssl.truststore.type" ||
              varName == "submarine.server.ssl.truststore.password"
          ) {
            this.stringValue = null;
          } else {
            this.stringValue = System.getenv(varName);
          }
          this.intValue = -1;
          this.floatValue = -1;
          this.longValue = -1;
          this.booleanValue = false;
          break;

        case INT:
          this.varName = varName;
          this.varClass = Integer.class;
          this.stringValue = null;
          this.intValue = Integer.valueOf(System.getenv(varName));
          this.floatValue = -1;
          this.longValue = -1;
          this.booleanValue = false;
          break;

        case LONG:
          this.varName = varName;
          this.varClass = Integer.class;
          this.stringValue = null;
          this.intValue = -1;
          this.floatValue = -1;
          this.longValue = Long.parseLong(System.getenv(varName), 10);
          this.booleanValue = false;
          break;

        case FLOAT:
          this.varName = varName;
          this.varClass = Float.class;
          this.stringValue = null;
          this.intValue = -1;
          this.longValue = -1;
          this.floatValue = Float.parseFloat(System.getenv(varName));
          this.booleanValue = false;
          break;

        case BOOLEAN:
          this.varName = varName;
          this.varClass = Boolean.class;
          this.stringValue = null;
          this.intValue = -1;
          this.longValue = -1;
          this.floatValue = -1;
          this.booleanValue = Boolean.parseBoolean(System.getenv(varName));
          break;
      }
      this.type = type;
      LOG.info(varName + ": Using new constructor!!!");
    }

    ConfVars(String varName, String varValue) {
      this.varName = varName;
      this.varClass = String.class;
      this.stringValue = (varValue == null ? "" : varValue);
      String stringValueFromEnv = System.getenv(varName);
      if (this.stringValue.equals(stringValueFromEnv)) {
        LOG.info(varName + ": Equal");
      } else {
        LOG.info("--------------- Error ---------------");
        LOG.info(varName + ": " + this.stringValue + " != " + stringValueFromEnv);
        LOG.info("-------------------------------------");
      }
      this.intValue = -1;
      this.floatValue = -1;
      this.longValue = -1;
      this.booleanValue = false;
      this.type = VarType.STRING;
    }

    ConfVars(String varName, int intValue) {
      this.varName = varName;
      this.varClass = Integer.class;
      this.stringValue = null;
      this.intValue = intValue;
      int intValueFromEnv = Integer.valueOf(System.getenv(varName));
      if (this.intValue == intValueFromEnv) {
        LOG.info(varName + ": Equal");
      } else {
        LOG.info("--------------- Error ---------------");
        LOG.info(varName + ": " + this.intValue + " != " + intValueFromEnv);
        LOG.info("-------------------------------------");
      }
      this.floatValue = -1;
      this.longValue = -1;
      this.booleanValue = false;
      this.type = VarType.INT;
    }

    ConfVars(String varName, long longValue) {
      this.varName = varName;
      this.varClass = Integer.class;
      this.stringValue = null;
      this.intValue = -1;
      this.floatValue = -1;
      this.longValue = longValue;
      long longValueFromEnv =  Long.parseLong(System.getenv(varName), 10);
      if (this.longValue == longValueFromEnv) {
        LOG.info(varName + ": Equal");
      } else {
        LOG.info("--------------- Error ---------------");
        LOG.info(varName + ": " + this.longValue + " != " + longValueFromEnv);
        LOG.info("-------------------------------------");
      }
      this.booleanValue = false;
      this.type = VarType.LONG;
    }

    ConfVars(String varName, float floatValue) {
      this.varName = varName;
      this.varClass = Float.class;
      this.stringValue = null;
      this.intValue = -1;
      this.longValue = -1;
      this.floatValue = floatValue;
      float floatValueFromEnv =  Float.parseFloat(System.getenv(varName));
      if (this.floatValue == floatValueFromEnv) {
        LOG.info(varName + ": Equal");
      } else {
        LOG.info("--------------- Error ---------------");
        LOG.info(varName + ": " + this.floatValue + " != " + floatValueFromEnv);
        LOG.info("-------------------------------------");
      }
      this.booleanValue = false;
      this.type = VarType.FLOAT;
    }

    ConfVars(String varName, boolean booleanValue) {
      this.varName = varName;
      this.varClass = Boolean.class;
      this.stringValue = null;
      this.intValue = -1;
      this.longValue = -1;
      this.floatValue = -1;
      this.booleanValue = booleanValue;
      boolean booleanValueFromEnv = Boolean.parseBoolean(System.getenv(varName));
      if (this.booleanValue == booleanValueFromEnv) {
        LOG.info(varName + ": Equal");
      } else {
        LOG.info("--------------- Error ---------------");
        LOG.info(varName + ": " + this.booleanValue + " != " + booleanValueFromEnv);
        LOG.info("-------------------------------------");
      }
      this.type = VarType.BOOLEAN;
    }

    public String getVarName() {
      return varName;
    }

    @SuppressWarnings("rawtypes")
    public Class getVarClass() {
      return varClass;
    }

    public int getIntValue() {
      return intValue;
    }

    public long getLongValue() {
      return longValue;
    }

    public float getFloatValue() {
      return floatValue;
    }

    public String getStringValue() {
      return stringValue;
    }

    public boolean getBooleanValue() {
      return booleanValue;
    }

    public VarType getType() {
      return type;
    }

    enum VarType {
      STRING {
        @Override
        void checkType(String value) throws Exception {
        }
      },
      INT {
        @Override
        void checkType(String value) throws Exception {
          Integer.valueOf(value);
        }
      },
      LONG {
        @Override
        void checkType(String value) throws Exception {
          Long.valueOf(value);
        }
      },
      FLOAT {
        @Override
        void checkType(String value) throws Exception {
          Float.valueOf(value);
        }
      },
      BOOLEAN {
        @Override
        void checkType(String value) throws Exception {
          Boolean.valueOf(value);
        }
      };

      boolean isType(String value) {
        try {
          checkType(value);
        } catch (Exception e) {
          LOG.error("Exception in SubmarineConfiguration while isType", e);
          return false;
        }
        return true;
      }

      String typeString() {
        return name().toUpperCase();
      }

      abstract void checkType(String value) throws Exception;
    }
  }
}
