/**
 * Copyright (C) <2019>  <chen junwen>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.mycat.plug.sequence;

import io.mycat.beans.mycat.MycatTable;
import io.mycat.config.plug.PlugRootConfig;
import java.util.HashMap;
import java.util.Map;

public class SequenceManager {

  private final Map<String, SequenceHandler> map = new HashMap<>();

  public void load(PlugRootConfig rootConfig) {

  }

  public SequenceHandler getSequenceBySequenceName(MycatTable table) {
    return null;
  }
}