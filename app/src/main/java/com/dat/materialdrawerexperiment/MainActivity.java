package com.dat.materialdrawerexperiment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.holder.BadgeStyle;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.view.BezelImageView;

public class MainActivity extends AppCompatActivity {

    private Drawer drawer;
    private PrimaryDrawerItem shopNameItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDrawer(savedInstanceState);
    }

    private void initDrawer(Bundle savedInstanceState) {


        shopNameItem = createShopNameDrawerItem();
        IDrawerItem closeShiftItem = createCloseShiftItem();
        IDrawerItem messageCenterItem = createMessageCenterItem();
        IDrawerItem homeItem = createHomeItem();
        IDrawerItem updateCatalogItem = createUpdateCatalogItem();
        IDrawerItem orderListItem = createOrderListItem();
        IDrawerItem customerListItem = createCustomerListItem();
        IDrawerItem printReportsItem = createPrintReportsItem();
        IDrawerItem settings = createSettingsDrawerItem();
        IDrawerItem block = createBlockDrawerItem();

        DrawerBuilder drawerBuilder = new DrawerBuilder()
                .withActivity(this)
                .withActionBarDrawerToggle(true)
                .withHeader(R.layout.custom_navigation_header)
                .withActionBarDrawerToggleAnimated(true)
                .addDrawerItems(
                        shopNameItem,
                        closeShiftItem,
                        new DividerDrawerItem(),
                        messageCenterItem,
                        new DividerDrawerItem(),
                        homeItem,
                        updateCatalogItem,
                        new DividerDrawerItem(),
                        orderListItem,
                        new DividerDrawerItem(),
                        customerListItem,
                        new DividerDrawerItem(),
                        settings,
                        new DividerDrawerItem(),
                        printReportsItem,
                        new DividerDrawerItem(),
                        block
                )
                .withItemAnimator(null)
                .withSavedInstance(savedInstanceState);
        drawer = drawerBuilder.build();
        BezelImageView imageView = (BezelImageView) drawer.getHeader().findViewById(R.id.material_drawer_account_header_current);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.avatar));
    }

    private PrimaryDrawerItem createShopNameDrawerItem() {
        //name and description should be set in showChannelInfo()
        return new PrimaryDrawerItem().withDescription("")
                .withName("")
                .withSelectable(false);
        // ToDo: add ID
    }


    private IDrawerItem createCloseShiftItem() {
        return new PrimaryDrawerItem()
                .withName(getString(R.string.drawer_close_shift))
                .withSelectable(false)
                .withIcon(FontAwesome.Icon.faw_circle);
        // ToDo: add ID
    }

    private PrimaryDrawerItem createMessageCenterItem() {
        return new PrimaryDrawerItem()
                .withName(getString(R.string.drawer_message_center))
                .withSelectable(false)
                .withBadge("24")
                .withBadgeStyle(new BadgeStyle(Color.GRAY, Color.GRAY).withTextColor(Color.WHITE))
                .withIcon(FontAwesome.Icon.faw_comment);
        // ToDo: add ID
    }

    private IDrawerItem createHomeItem() {
        return new PrimaryDrawerItem()
                .withName(getString(R.string.drawer_main))
                .withSelectable(false)
                .withIcon(FontAwesome.Icon.faw_home)
                .withIdentifier(DRAWER_MAIN_ID);
    }

    public static final int DRAWER_BALANCE_ID = 0x40000001;
    public static final int DRAWER_MAIN_ID = 0x40000002;
    public static final int DRAWER_CATALOG_ID = 0x40000003;
    public static final int DRAWER_ORDER_LIST_ID = 4;
    public static final int DRAWER_FAVORITES_ID = 0x40000005;
    public static final int DRAWER_FREE_PRICE_ID = 0x40000006;
    public static final int DRAWER_SETTINGS_ID = 0x40000007;
    public static final int DRAWER_BLOCK_ID = 0x40000008;

    private IDrawerItem createUpdateCatalogItem() {
        return new PrimaryDrawerItem()
                .withName(getString(R.string.drawer_update_catalog))
                .withSelectable(false)
                .withIcon(FontAwesome.Icon.faw_repeat);
        // ToDo: add ID
    }

    private IDrawerItem createOrderListItem() {
        return new PrimaryDrawerItem()
                .withName(getString(R.string.drawer_order_list))
                .withSelectable(false)
                .withIcon(FontAwesome.Icon.faw_clock_o)
                .withIdentifier(DRAWER_ORDER_LIST_ID);
    }

    private IDrawerItem createCustomerListItem() {
        return new PrimaryDrawerItem()
                .withName(getString(R.string.drawer_customer_list))
                .withSelectable(false)
                .withIcon(FontAwesome.Icon.faw_user);
        // ToDo: add ID
    }

    private IDrawerItem createPrintReportsItem() {
        return new PrimaryDrawerItem()
                .withName(getString(R.string.drawer_print_reports))
                .withSelectable(false)
                .withIcon(FontAwesome.Icon.faw_print);
        // ToDo: add ID
    }


    private PrimaryDrawerItem createSettingsDrawerItem() {
        return new PrimaryDrawerItem()
                .withName(getString(R.string.drawer_settings))
                .withIcon(FontAwesome.Icon.faw_check)
                .withIdentifier(DRAWER_SETTINGS_ID);
    }

    private PrimaryDrawerItem createBlockDrawerItem() {
        return new PrimaryDrawerItem()
                .withName(getString(R.string.drawer_block))
                .withIcon(FontAwesome.Icon.faw_check)
                .withIdentifier(DRAWER_BLOCK_ID)
                .withSelectable(false);
    }

}
