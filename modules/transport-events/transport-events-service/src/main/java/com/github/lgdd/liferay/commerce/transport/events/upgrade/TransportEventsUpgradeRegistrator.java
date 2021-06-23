package com.github.lgdd.liferay.commerce.transport.events.upgrade;

import com.github.lgdd.liferay.commerce.transport.events.upgrade.v1_1_0.UpgradeSchema;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;
import org.osgi.service.component.annotations.Component;

@Component(
    immediate = true,
    service = UpgradeStepRegistrator.class
)
public class TransportEventsUpgradeRegistrator
    implements UpgradeStepRegistrator {

  @Override
  public void register(Registry registry) {

    registry.register("1.0.0", "1.1.0", new UpgradeSchema());
  }

}
