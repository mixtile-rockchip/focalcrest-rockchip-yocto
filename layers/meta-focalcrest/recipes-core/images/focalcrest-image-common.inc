# SPDX-License-Identifier: MIT
# Copyright (c) 2026 Focalcrest

# Runtime and access capabilities shared by every Focalcrest image.
CORE_IMAGE_EXTRA_INSTALL += "packagegroup-focalcrest-base"

# Convenience access is a common capability shared by every image.
IMAGE_FEATURES += " \
    ssh-server-openssh \
    allow-empty-password \
    allow-root-login \
    empty-root-password \
    serial-autologin-root \
"

inherit image-buildinfo
IMAGE_BUILDINFO_VARS:append = " DATETIME"

# The root partition is grown by systemd-repart (50-root.conf in
# focalcrest-rootfs-grow); systemd-growfs then grows the filesystem.
focalcrest_growfs_fstab() {
    sed -i -E "s|^(/dev/root[[:space:]]+/[[:space:]]+auto[[:space:]]+)(defaults)([[:space:]]+1[[:space:]]+1)|\1\2,x-systemd.growfs\3|" ${IMAGE_ROOTFS}/etc/fstab
}

ROOTFS_POSTPROCESS_COMMAND += "focalcrest_growfs_fstab;"
