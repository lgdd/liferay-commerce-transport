package com.github.lgdd.liferay.commerce.transport.events.upgrade.v1_1_0;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.github.lgdd.liferay.commerce.transport.events.model.impl.TransportEventModelImpl;

public class UpgradeSchema
    extends UpgradeProcess {

  @Override
  protected void doUpgrade()
      throws Exception {

    String statusColumnName = "status";
    String commerceAccountColumnName = "commerceAccountName";

    if (!hasColumn(TransportEventModelImpl.TABLE_NAME, statusColumnName)) {
      runSQL(
          String.format(
              "ALTER TABLE %s ADD COLUMN %s BIGINT",
              TransportEventModelImpl.TABLE_NAME,
              statusColumnName
          )
      );
    }

    if (!hasColumn(TransportEventModelImpl.TABLE_NAME, commerceAccountColumnName)) {
      runSQL(
          String.format(
              "ALTER TABLE %s ADD COLUMN %s VARCHAR(75)",
              TransportEventModelImpl.TABLE_NAME,
              commerceAccountColumnName
          )
      );
    }
  }
}
