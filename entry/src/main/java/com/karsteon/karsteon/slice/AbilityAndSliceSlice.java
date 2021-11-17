package com.karsteon.karsteon.slice;

import com.karsteon.karsteon.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.components.*;
import ohos.agp.utils.TextAlignment;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;
import ohos.system.DeviceInfo;

import java.util.ArrayList;
import java.util.List;

public class AbilityAndSliceSlice extends AbilitySlice {
    private List<DataItem> items = new ArrayList<>();
    class DataItem {
        public String text;
        public String action;
        public DataItem(String text, String  action) {
            this.text = text;
            this.action = action;
        }
    }
    class DataProvider extends RecycleItemProvider {
        @Override
        public Object getItem(int i) {
            return null;
        }

        private List<DataItem> list;

        private AbilitySlice slice;

        public DataProvider(List<DataItem> list) {
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }



        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public Component getComponent(int i, Component component, ComponentContainer componentContainer) {
            if (component == null) {
                Text text = new Text(componentContainer.getContext());
                text.setTextSize(40);
                text.setWidth(StackLayout.LayoutConfig.MATCH_PARENT);
                text.setHeight(StackLayout.LayoutConfig.MATCH_CONTENT);
                text.setText(((DataItem) this.list.get(i)).text);
                if(DeviceInfo.getDeviceType().equals("wearable")) {
                    text.setTextAlignment(TextAlignment.CENTER);
                }

                return text;
            } else {
                Text text = (Text)component;
                text.setText(((DataItem) this.list.get(i)).text);;
                return component;
            }
        }

    }


    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_list_layout);

        ListContainer listContainer = (ListContainer)this.findComponentById(ResourceTable.Id_listcontainer);

        if(listContainer != null) {
            items.add(new DataItem("返回",""));
            items.add(new DataItem("显式使用Intent","explicit_intent"));
            items.add(new DataItem("隐式使用Intent","implicit_intent"));
            items.add(new DataItem("Page Ability之间的交互","ability_interactive"));
            items.add(new DataItem("Page Ability的启动类型","launch_type"));
            items.add(new DataItem("Ability Slice基础","basic_slice"));
      //      items.add(new DataItem(" ","none"));
            listContainer.setItemProvider(new DataProvider(items));

        }
        listContainer.setEnabled(true);

        listContainer.setItemClickedListener(new ListContainer.ItemClickedListener() {
            @Override
            public void onItemClicked(ListContainer listContainer, Component component, int i, long l) {
                int index = i;
                if(DeviceInfo.getDeviceType().equals("tv")) {
                  //  index--;
                }
                String action = items.get(index).action;
                switch (action) {
                    case "":  // 如果为空串，返回到上一个窗口
                        Intent intentDefaultx = new Intent();
                        Operation operationx = new Intent.OperationBuilder()
                                .withBundleName("com.unitymarvel.demo")
                                .withAbilityName("com.unitymarvel.demo.ability.TargetAbility")
                                .build();

                        intentDefaultx.setOperation(operationx);
                        intentDefaultx.setParam("name","Bill");
                        intentDefaultx.setParam("age",20);
                        intentDefaultx.setParam("data", new int[]{1,2,3,4,5});


                        // startAbility(intent3);
                        startAbilityForResult(intentDefaultx,99);
                       // AbilityAndSliceSlice.this.terminateAbility();
                        break;
                    case "explicit_intent":    // 显式使用Intent

                        Intent intent1 = new Intent();
                        Operation operation1 = new Intent.OperationBuilder()
                                .withBundleName("com.unitymarvel.demo")
                                .withAbilityName("com.unitymarvel.demo.ability.ExplicitIntentAbility")
                                .build();

                        intent1.setOperation(operation1);
                        startAbility(intent1);
                        break;
                    case "implicit_intent":        // 隐式使用Intent
                        Intent intent2 = new Intent();
                        intent2.setAction("action.harmonyos.demo.intentaction");
                        startAbility(intent2);

                        break;

                    case "ability_interactive":   // Page Ability之间的交互

                        Intent intent3 = new Intent();
                        Operation operation3 = new Intent.OperationBuilder()
                                .withBundleName("com.unitymarvel.demo")
                                .withAbilityName("com.unitymarvel.demo.ability.TargetAbility")
                                .build();

                        intent3.setOperation(operation3);
                        intent3.setParam("name","Bill");
                        intent3.setParam("age",20);
                        intent3.setParam("data", new int[]{1,2,3,4,5});


                        // startAbility(intent3);
                        startAbilityForResult(intent3,99);

                        break;
                    case "launch_type":
                        Intent intent4 = new Intent();
                        intent4.setAction("action.harmonyos.demo.ability.launchtype");
                        startAbility(intent4);

                        break;
                    case "basic_slice":
                        Intent intent5 = new Intent();
                        intent5.setAction("action.harmonyos.demo.ability.basicslice");
                        startAbility(intent5);
                        break;

                    default:
                        Intent intentDefault = new Intent();
                        Operation operation4 = new Intent.OperationBuilder()
                                .withBundleName("com.unitymarvel.demo")
                                .withAbilityName("com.unitymarvel.demo.ability.TargetAbility")
                                .build();

                        intentDefault.setOperation(operation4);
                        intentDefault.setParam("name","Bill");
                        intentDefault.setParam("age",20);
                        intentDefault.setParam("data", new int[]{1,2,3,4,5});


                        // startAbility(intent3);
                        startAbilityForResult(intentDefault,99);

                        break;
                }
            }
        });
    }

    @Override
    protected void onAbilityResult(int requestCode, int resultCode, Intent resultData) {
        switch (requestCode) {
            case 99:
                switch (resultCode) {
                    case 100:
                        String result = resultData.getStringParam("result");
                        HiLogLabel label = new HiLogLabel(HiLog.LOG_APP ,200, "Ability_Result_Tag");
                        HiLog.info(label, result,"");
                        break;
                }
                break;
        }
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
