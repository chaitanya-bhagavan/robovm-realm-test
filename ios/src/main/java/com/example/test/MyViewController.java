package com.example.test;

import org.robovm.apple.foundation.NSString;
import org.robovm.apple.uikit.UILabel;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.objc.annotation.CustomClass;
import org.robovm.objc.annotation.IBAction;
import org.robovm.objc.annotation.IBOutlet;
import org.robovm.pods.realm.RLMRealm;

@CustomClass("MyViewController")
public class MyViewController extends UIViewController {
    private static CounterStore counterStore = new CounterStore();

    private UILabel label;

    @IBOutlet
    public void setLabel(UILabel label) {
        this.label = label;
    }

    @IBAction
    private void clicked() {

        final RLMRealm realm = RLMRealm.realmWithPath("/tmp/test.realm");

        realm.beginWriteTransaction();
        TestObj t = new TestObj();
        t.setName("new name");
        t.setType("new type");
        realm.addObject(t);
        realm.commitWriteTransaction();


        counterStore.add(1);
        label.setText("Click Nr. " + counterStore.get());
    }
}
