# Liferay Commerce Transport

Liferay Commerce modules to facilitate shipments planning and tracking.

![planned-available-shipments](https://github.com/lgdd/doc-assets/blob/main/liferay-commerce-transport/planned-available-shipments.png?raw=true)

## How to use

First, we need to initalize a Commerce site with the modules:

- Deploy the modules on Liferay 7.3 (DXP/Portal)
- Create a new site using Minium (you might need to reindex: *Control Panel > Search > Index Actions > Reindex all search indexes.*)
- Create a new page and add the *Transport Planning* widget
- Create a new Account and associate your user to it (*Control Panel > Accounts*)

Now, we can take advantage of those modules:

- Add a product to your cart
- Open your cart and click *Submit*
- Complete the checkout
- Open the administration panel and go to *Commerce > Orders*
- Select your previous order
- Click on *Accept order* and then *Create shipment*

If you go back to the page with the *Transport Planning* widget, you should see the new shipment under *Available Shipments*.

- Click on *Plan*
- Change the dates
- Click on *Save*

Now, you should see the shipment under Planned Shipment. The action button allows you to update it or view the events of this shipment:

![shipment-events](https://github.com/lgdd/doc-assets/blob/main/liferay-commerce-transport/shipment-events.png?raw=true)

## License

[MIT](LICENSE)