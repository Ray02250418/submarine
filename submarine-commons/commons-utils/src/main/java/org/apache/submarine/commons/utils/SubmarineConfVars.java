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
    SUBMARINE_CONF_DIR("submarine.conf.dir", System.getenv("SUBMARINE_CONF_DIR")),
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
        "workbench.websocket.max.text.message.size",
        System.getenv("WORKBENCH_WEBSOCKET_MAX_TEXT_MESSAGE_SIZE")),
    WORKBENCH_WEB_WAR("workbench.web.war", System.getenv("WORKBENCH_WEB_WAR")),
    SUBMARINE_RUNTIME_CLASS("submarine.runtime.class", System.getenv("SUBMARINE_RUNTIME_CLASS")),
    SUBMARINE_SUBMITTER("submarine.submitter", System.getenv("SUBMARINE_SUBMITTER")),
    SUBMARINE_SERVER_SERVICE_NAME("submarine.server.service.name",
        System.getenv("SUBMARINE_SERVER_SERVICE_NAME")),
    ENVIRONMENT_CONDA_MIN_VERSION("environment.conda.min.version",
        System.getenv("ENVIRONMENT_CONDA_MIN_VERSION")),
    ENVIRONMENT_CONDA_MAX_VERSION("environment.conda.max.version",
        System.getenv("ENVIRONMENT_CONDA_MAX_VERSION"));

    private String varName;
    @SuppressWarnings("rawtypes")
    private Class varClass;
    private String stringValue;
    private VarType type;
    private int intValue;
    private float floatValue;
    private boolean booleanValue;
    private long longValue;


    ConfVars(String varName, String varValue) {
      this.varName = varName;
      this.varClass = String.class;
      this.stringValue = varValue;
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
