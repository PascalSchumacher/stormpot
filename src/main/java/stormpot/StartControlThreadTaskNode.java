/*
 * Copyright (C) 2011-2014 Chris Vest (mr.chrisvest@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package stormpot;

/**
 * A foreground task that starts the {@link ProcessController}.
 */
class StartControlThreadTaskNode extends TaskNode {
  private final Runnable startControllerCallback;

  /**
   * Construct a foreground task node that will start the background process
   * control thread via the given callback.
   *
   * @param startControllerCallback The callback that, when run, will start the
   *                                ProcessController.
   */
  StartControlThreadTaskNode(Runnable startControllerCallback) {
    super(true);
    this.startControllerCallback = startControllerCallback;
  }

  @Override
  void execute() {
    startControllerCallback.run();
  }
}
