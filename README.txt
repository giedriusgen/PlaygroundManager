Created a playground library that implements business logic for playground management module.

Here is the task:


Create a playground library (JAR) that implements business logic for playground

management module within Some™ system.

These are things that we expect library will do:

• Define clear and usable domain classes, beans, components (interfaces) that should be used

by Some™ system to access required functionality / data.

• Currently Some™ system controls double swings, carousel, slide and a ball pit play sites.

• When incorporating library into Some™ system, it should be able to configure various

combinations of play sites (for example two swings, one slide etc.).

• Library should NOT do any DB related operations, or use persistent data store, Some™

system only needs ability to read current playground state, for this in memory storage is

enough.

• Some™ must be able to add kids to play sites (we know kid's name, age, ticket number):

? it should be possible to enqueue kid or receive negative result if kid does not accept

waiting in queue

? it should also be possible to remove kid from play site / queue.

• Play sites should not allow to add more kids to them than specified in configuration (or

implementation in case of double swings) of play site (done once on initialization).

• Play site utilization is calculated differently for each play site (most of play sites utilization

is percent of capacity taken (3/10 places taken for 30% utilization), double swings 100% if

full capacity, 0 if 1 or 0 kids, some not yet known play sites can have different calculation

implementations, this possible extension requirement should reflect in design) utilization is

measured in percents (%).

• Register play site utilization during working hours (snapshots with configurable interval),

provide data on request for Some™ system.

• Register queues on play sites (queue appears when Some™ tries to add kid to play site, that

is full, and kid accepts waiting in queue).

• Implement VIP feature, where it would be possible to designate ticket with a possibility to

skip line X times, BUT a queue must maintain a balance of max 1 skip for 3 normal entries

(ex. if there are 5 waiting, and 2 vips come, one would get into front of line, second would

be after 3 non vip's would enter the play site, and total order would be VNNNVNN).

• Library should be able to provide history on what play sites kid played, and how long.

• Library should be able to provide a total visitor count during a day on all registered play

sites.

• Library should be able to provide a play site utilization snapshots taken during the working

hours.

• Reports can be provided as collections of classes (objects) representing data points.

• Some proof should be provided, that show how the library works.

