# SPDX-License-Identifier: MIT
# Copyright (c) 2026 Focalcrest

# systemd-repart is used by focalcrest-rootfs-grow.  It is not built by
# default and requires openssl.
PACKAGECONFIG:append = " repart openssl"
