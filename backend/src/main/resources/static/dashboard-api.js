document.addEventListener('DOMContentLoaded', () => {
    const API_URL = 'http://localhost:8080/api/dashboard/stats';

    async function fetchDashboardStats() {
        try {
            const response = await fetch(API_URL);
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            const data = await response.json();

            // Update DOM
            updateStat('stat-total-users', data.totalUsers);
            updateStat('stat-active-jobs', data.activeJobs);
            updateStat('stat-revenue', formatCurrency(data.revenue));
            updateStat('stat-disputes', data.openDisputes);

        } catch (error) {
            console.error('Failed to fetch dashboard stats:', error);
        }
    }

    function updateStat(elementId, value) {
        const el = document.getElementById(elementId);
        if (el) {
            el.textContent = value;
            // formatted value animation could go here
        }
    }

    function formatCurrency(value) {
        return new Intl.NumberFormat('en-US', {
            style: 'currency',
            currency: 'USD'
        }).format(value);
    }

    fetchDashboardStats();
});
