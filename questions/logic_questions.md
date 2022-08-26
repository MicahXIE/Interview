Two Eggs Problem
A building has 100 floors. One of the floors is the highest floor an egg can be dropped from without breaking.

If an egg is dropped from above that floor, it will break. If it is dropped from that floor or below, it will be completely undamaged and you can drop the egg again.

Given two eggs, find the highest floor an egg can be dropped from without breaking, with as few drops as possible.


Answer:
If the egg doesn’t break on the first drop our drop count increases by one, so we’ll need to remove a drop from our floor by floor drop count — the next drop should be from x-1 floors up. Every additional floor jump will need to have one less floor, so that when we get to the linear portion of the solution we’ll have one less floor to check. We continue removing one floor until we only have 1 floor to check:

x + (x-1) + (x-2) + (x-3) + ... + 1
Which simplifies to:
x(x + 1)/2


x(x + 1)/2 = 100
And some math...
x = 13.651
This means we want to start dropping from floor 14, jump up 13 floors to drop from floor 27, jump up 12 floors to drop from floor 39, and so on. Our worst case scenario is then a drop count total of 14.