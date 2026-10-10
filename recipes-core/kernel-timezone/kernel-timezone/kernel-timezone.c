// SPDX-FileCopyrightText: 2026 Darrel Griët <dgriet@gmail.com>
// SPDX-License-Identifier: GPL-3.0-only

#include <stdio.h>
#include <sys/syscall.h>
#include <sys/time.h>
#include <time.h>
#include <unistd.h>

int main(void)
{
    struct timezone old = { 0, 0 };
    struct timezone new = { 0, 0 };
    time_t now = time(NULL);
    struct tm tm;

    if (syscall(SYS_gettimeofday, NULL, &old) < 0) {
        perror("gettimeofday");
        return 1;
    }
    if (!localtime_r(&now, &tm)) {
        perror("localtime_r");
        return 1;
    }
    new.tz_minuteswest = -tm.tm_gmtoff / 60;
    if (syscall(SYS_settimeofday, NULL, &new) < 0) {
        perror("settimeofday");
        return 1;
    }
    printf("%d -> %d\n", old.tz_minuteswest, new.tz_minuteswest);
    return 0;
}
