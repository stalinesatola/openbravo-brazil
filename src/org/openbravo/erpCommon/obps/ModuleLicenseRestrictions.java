/*
 *************************************************************************
 * The contents of this file are subject to the Openbravo  Public  License
 * Version  1.1  (the  "License"),  being   the  Mozilla   Public  License
 * Version 1.1  with a permitted attribution clause; you may not  use this
 * file except in compliance with the License. You  may  obtain  a copy of
 * the License at http://www.openbravo.com/legal/license.html 
 * Software distributed under the License  is  distributed  on  an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific  language  governing  rights  and  limitations
 * under the License. 
 * The Original Code is Openbravo ERP. 
 * The Initial Developer of the Original Code is Openbravo SLU 
 * All portions are Copyright (C) 2015 Openbravo SLU 
 * All Rights Reserved. 
 * Contributor(s):  ______________________________________.
 ************************************************************************
 */
package org.openbravo.erpCommon.obps;

import javax.enterprise.context.ApplicationScoped;

import org.openbravo.erpCommon.obps.ActivationKey.LicenseRestriction;
import org.openbravo.xmlEngine.XmlEngine;

/**
 * Modules can check for License restrictions. To do so this interface should be implemented.
 * 
 * @author alostale
 *
 */
@ApplicationScoped
public interface ModuleLicenseRestrictions {
  /**
   * Returns LicenseRestrictions applicable to this instance, or null or
   * LicenseRestriction.NO_RESTRICTION in case of no restriction.
   */
  public LicenseRestriction checkRestrictions(ActivationKey activationKey, String currentSession);

  /**
   * Returns a message related to activation key or null none required. It will be shown in:
   * <ul>
   * <li>Login Page
   * <li>Instance Activation window
   * </ul>
   */
  public ActivationMsg getActivationMessage(ActivationKey activationKey, String lang);

  /** Provides the HTML to be injected in Instance Activation window to perform additional actions */
  public String getInstanceActivationExtraActionsHtml(XmlEngine xmlEngine);

  public enum MsgSeverity {
    WARN("Warning"), ERROR("Error");

    private String type;

    MsgSeverity(String type) {
      this.type = type;
    }

    MsgSeverity forType(String typeToCheck) {
      for (MsgSeverity severity : MsgSeverity.values()) {
        if (typeToCheck.equals(severity.toString())) {
          return severity;
        }
      }
      // fallback, if not found return error
      return ERROR;
    }

    @Override
    public String toString() {
      return type;
    }
  }

  /** holder for activation key messages */
  public class ActivationMsg {
    private MsgSeverity severity;
    private String msgText;

    public ActivationMsg(MsgSeverity severity, String msgText) {
      this.severity = severity;
      this.msgText = msgText;
    }

    public MsgSeverity getSeverity() {
      return severity;
    }

    public String getMsgText() {
      return msgText;
    }
  }
}
