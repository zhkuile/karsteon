package com.karsteon.karsteon.layout.ability;

import com.karsteon.karsteon.ResourceTable;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.agp.components.*;


public class LayoutScatterAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);

        PositionLayout  positionLayout = (PositionLayout)LayoutScatter.getInstance(this).parse(ResourceTable.Layout_scatter_layout, null, false);
        super.setUIContent(positionLayout);

        DirectionalLayout directionalLayout = (DirectionalLayout) LayoutScatter.getInstance(this).parse(ResourceTable.Layout_image_item,null,false);
        Image image =(Image) directionalLayout.findComponentById(ResourceTable.Id_image);
        if(image != null) {
            image.setScaleMode(Image.ScaleMode.ZOOM_CENTER);
            image.setPixelMap(ResourceTable.Media_components);
        }

        Button button = (Button)directionalLayout.findComponentById(ResourceTable.Id_button);
        if(button != null) {
            button.setText("Components");
        }

        DirectionalLayout directionalLayout1 = (DirectionalLayout) LayoutScatter.getInstance(this).parse(ResourceTable.Layout_image_item,null,false);
        image = (Image)directionalLayout1.findComponentById(ResourceTable.Id_image);
        if(image != null) {
            image.setScaleMode(Image.ScaleMode.ZOOM_CENTER);
            image.setPixelMap(ResourceTable.Media_ability);
        }
        Button button1 =(Button) directionalLayout1.findComponentById(ResourceTable.Id_button);

        if(button1!=null) {
            button1.setText("ability");
        }

        //第三次动态装载image_item xml
        DirectionalLayout directionalLayout2 = (DirectionalLayout) LayoutScatter.getInstance(this).parse(ResourceTable.Layout_image_item,null,false);
        image = (Image)directionalLayout2.findComponentById(ResourceTable.Id_image);
        if(image != null) {
            image.setScaleMode(Image.ScaleMode.ZOOM_CENTER);
            image.setPixelMap(ResourceTable.Media_ability);
        }
        Button button2=(Button) directionalLayout2.findComponentById(ResourceTable.Id_button);

        if(button1!=null) {
            button1.setText("device");
        }

        // 第三次动态装载 image_item xml 布局文件对应的组件添加到容器组件
        positionLayout.addComponent(directionalLayout);
        positionLayout.addComponent(directionalLayout1);
        positionLayout.addComponent(directionalLayout2);

        // 设置组件的绝对位置
        directionalLayout.setContentPosition(300,200);
        directionalLayout1.setContentPosition(400,600);
        directionalLayout2.setContentPosition(600,900);
    }

}
