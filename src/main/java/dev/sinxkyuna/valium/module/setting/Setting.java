package dev.sinxkyuna.valium.module.setting;

import dev.sinxkyuna.valium.module.setting.impl.BooleanSetting;
import dev.sinxkyuna.valium.module.setting.impl.ModeSetting;
import dev.sinxkyuna.valium.module.setting.impl.MultiModeSetting;
import dev.sinxkyuna.valium.module.setting.impl.newmodesetting.NewModeSetting;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public abstract class Setting {
    private String name;
    private final List<BooleanSetting> dependencyBoolSettings;
    private final List<Boolean> dependencyBools;
    private final List<ModeSetting> dependencyModeSettings;
    private final List<String> dependencyModes;
    private final List<NewModeSetting> dependencyNewModeSettings;
    private final List<String> dependencyNewModes;
    @Getter
    private final List<MultiModeSetting> dependencyMultiModeSettings;
    @Getter
    private final List<String> dependencyMultiModes;

    public Setting(String name) {
        this.name = name;
        this.dependencyBoolSettings = new ArrayList<>();
        this.dependencyBools = new ArrayList<>();
        this.dependencyModeSettings = new ArrayList<>();
        this.dependencyModes = new ArrayList<>();
        this.dependencyNewModeSettings = new ArrayList<>();
        this.dependencyNewModes = new ArrayList<>();
        this.dependencyMultiModeSettings = new ArrayList<>();
        this.dependencyMultiModes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BooleanSetting> getDependencyBoolSettings() {
        return dependencyBoolSettings;
    }

    public List<Boolean> getDependencyBools() {
        return dependencyBools;
    }

    public List<ModeSetting> getDependencyModeSettings() {
        return dependencyModeSettings;
    }

    public List<String> getDependencyModes() {
        return dependencyModes;
    }

    public List<NewModeSetting> getDependencyNewModeSettings() {
        return dependencyNewModeSettings;
    }

    public List<String> getDependencyNewModes() {
        return dependencyNewModes;
    }

    public void addDependency(BooleanSetting dependencyBoolSetting, boolean dependencyBool) {
        this.dependencyBoolSettings.add(dependencyBoolSetting);
        this.dependencyBools.add(dependencyBool);
    }

    public void addDependency(ModeSetting dependencyModeSetting, String dependencyMode) {
        this.dependencyModeSettings.add(dependencyModeSetting);
        this.dependencyModes.add(dependencyMode);
    }

    public void addDependency(NewModeSetting dependencyNewModeSetting, String dependencyNewMode) {
        this.dependencyNewModeSettings.add(dependencyNewModeSetting);
        this.dependencyNewModes.add(dependencyNewMode);
    }

    public void addDependency(MultiModeSetting multiModeSetting, String dependencyMode) {
        this.dependencyMultiModeSettings.add(multiModeSetting);
        this.dependencyMultiModes.add(dependencyMode);
    }
}
