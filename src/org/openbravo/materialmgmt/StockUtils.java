/*
 *************************************************************************
 * The contents of this file are subject to the Openbravo  Public  License
 * Version  1.0  (the  "License"),  being   the  Mozilla   Public  License
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
 *************************************************************************
 */
package org.openbravo.materialmgmt;

import java.math.BigDecimal;

import javax.servlet.ServletException;

import org.openbravo.dal.service.OBDal;
import org.openbravo.exception.NoConnectionAvailableException;
import org.openbravo.service.db.DalConnectionProvider;

public class StockUtils {
  /*
   * Calls M_GET_STOCK_PARAM and retrieves result in a CSResponseGetStockParam object. Records will
   * be created in M_STOCK_PROPOSAL with AD_PINSTASNCE_ID = uuid (parameter).
   */
  public static CSResponseGetStockParam getStock(String uuid, String recordId, BigDecimal quantity,
      String mProductId, String mLocatorId, String mWarehouseId, String priorityWarehouseId,
      String adOrgId, String mAttributeSetInstanceId, String adUserId, String adClientId,
      String warehouseRuleId, String cUomId, String productUomId, String adTableId, String auxId,
      Long lineNo, String processId, String mReservationId, String calledFromApp)
      throws ServletException, NoConnectionAvailableException {
    return StockUtilsData.getStock(OBDal.getInstance().getConnection(true),
        new DalConnectionProvider(true), uuid, recordId, quantity != null ? quantity.toString()
            : null, mProductId, mLocatorId, mWarehouseId, priorityWarehouseId, adOrgId,
        mAttributeSetInstanceId, adUserId, adClientId, warehouseRuleId, cUomId, productUomId,
        adTableId, auxId, lineNo != null ? lineNo.toString() : null, processId, mReservationId,
        calledFromApp);
  }
}
