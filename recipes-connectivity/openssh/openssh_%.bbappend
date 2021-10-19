PACKAGECONFIG:remove = "rng-tools"

EXTRA_OECONF:append = " --with-sandbox=rlimit"
