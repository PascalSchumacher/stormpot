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

import java.util.concurrent.locks.LockSupport;

/**
 * A {@link TaskNode} that runs in the foreground, and will unpark a thread.
 */
class BlockedTaskNode extends TaskNode {
  private final Thread thread;
  private volatile boolean unparked;

  /**
   * Construct a foreground task that will unpark the given thread when
   * executed.
   *
   * @param thread The thread to unpark.
   */
  BlockedTaskNode(Thread thread) {
    super(true);
    this.thread = thread;
  }

  /**
   * Unparks the thread specified to the constructor.
   */
  @Override
  void execute() {
    unparked = true;
    LockSupport.unpark(thread);
  }

  void park(Object blocker) {
    if (!unparked) {
      LockSupport.park(blocker);
      unparked = false;
    }
  }
}
