/*
 * Copyright 2000-2017 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.intellij.ui.components;

import com.intellij.openapi.util.registry.Registry;
import com.intellij.openapi.util.registry.RegistryValue;

import javax.swing.*;
import java.awt.*;

public class ScrollSettings {
  private static final RegistryValue HEADER_OVER_CORNER = Registry.get("ide.scroll.layout.header.over.corner");

  private ScrollSettings() {
  }

  static boolean isHeaderOverCorner(JViewport viewport) {
    Component view = viewport == null ? null : viewport.getView();
    return !isNotSupportedYet(view) && HEADER_OVER_CORNER.asBoolean();
  }

  static boolean isNotSupportedYet(Component view) {
    return view instanceof JTable;
  }
}
