/*
 * Copyright © 2011-2019 Chris Vest (mr.chrisvest@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package stormpot;

abstract class AllocatorProcess<T extends Poolable> {
  abstract Completion shutdown();

  abstract void offerDeadSlot(BSlot<T> slot);

  abstract void setTargetSize(int size);

  abstract int getTargetSize();

  abstract long getAllocationCount();

  abstract long getFailedAllocationCount();

  abstract long countLeakedObjects();
}
